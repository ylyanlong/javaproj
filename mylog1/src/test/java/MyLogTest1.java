import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2015/11/18.
 */
public class MyLogTest1 {
    private static final Logger LOG = LoggerFactory.getLogger(MyLogTest1.class);

    public static void main(String[] args){
        LOG.debug("MyLogTest1 debug");
        LOG.info("MyLogTest1 info");
        LOG.warn("MyLogTest1 warn");
        LOG.error("MyLogTest1 error");
    }
}
