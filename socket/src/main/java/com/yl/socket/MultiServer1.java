package com.yl.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
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
            BufferedReader in = null;
            PrintWriter out = null;

            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream());

                while (true){
                    // in and out is here
                    //System.out.println("enter while");
                    String cmd = in.readLine();
                    if(cmd == null){
                        System.out.println("cmd is null");
                        break;
                    }
                    System.out.println("client:" + cmd);
                    out.println("server: " + cmd);
                    out.flush();
                }// end while
            } catch (IOException e) {
                LOG.info("IOException in while");
                // e.printStackTrace();
            }finally {
                try {
                    out.close();
                    in.close();
                    socket.close();
                } catch (Exception e) {
                    LOG.error("CommandService socket close fail!", e);
                }
            }

            LOG.info("HandleClient:{} close", counter);
        }// end run()
    }

}
