package com.yl.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/5/13.
 */
public class MultiServer1 {
    private static final Logger LOG = LoggerFactory.getLogger(MultiServer1.class);

    public static void main(String[] args) {
        final int PORT = 10001;

        // 处理客户端请求的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        MultiServer1.startServer(PORT, executorService);


    }// end main()

    private static void startServer(final int PORT, ExecutorService executorService) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            LOG.info("begin accept");
            int clientNum = 1;

            while (true) {
                Socket socket = server.accept();
                executorService.execute(new HandleClient(socket));
                // LOG.info("accept: {} client", clientNum);
                LOG.info("accept: {}", clientNum);
                clientNum++;
            }

        } catch (IOException e) {
            executorService.shutdown();
            LOG.info("startServer e executorService shutdown");
            e.printStackTrace();
        }
        LOG.info("startServer o executorService shutdown");
        executorService.shutdown();
    }

    private static class HandleClient implements Runnable {
        private static int counter = 0;
        private Socket socket;

        public HandleClient(Socket socket) {
            counter++;
            this.socket = socket;
        }

        @Override
        public void run() {
            DataInputStream in = null;
            DataOutputStream out = null;

            try {
                while (true){
                    in = new DataInputStream(socket.getInputStream());
                    out = new DataOutputStream(socket.getOutputStream());

                    System.out.println(in.readDouble());
                    out.writeDouble(0.6 + counter);
                }// end while
            } /*catch (EOFException e){
                LOG.info("EOFException in while");
                e.printStackTrace();
            }*/ catch (IOException e) {
                LOG.info("IOException in while");
                // e.printStackTrace();
            }

            LOG.info("HandleClient:{} close", counter);
        }// end run()
    }

}
