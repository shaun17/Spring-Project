package thread;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class UseCountDownLatch {
    private final static Log log = LogFactory.getLog(UseCountDownLatch.class);
    private final static CountDownLatch ct = new CountDownLatch(5);

    public static void main(String[] args) throws InterruptedException {
        log.info("===== main start =====");
        log.info("***** thead1 start *****");
       new Thread(()->{
            IntStream.rangeClosed(1,2).boxed().forEach(x-> {ct.countDown();log.warn(ct.getCount());});
        }).start();
        log.info("***** thead1 end *****");
        log.info("===== thead sleep "+ LocalDateTime.now() +" start =====");
        Thread.sleep(2000);
        log.info("===== thead sleep "+ LocalDateTime.now() +" end =====");
        log.info("***** thead2 start *****");

        new Thread(()->{
            IntStream.rangeClosed(1,3).boxed().forEach(x-> {ct.countDown();log.warn(ct.getCount());});
        }).start();
        log.info("***** thead2 end *****");
        ct.await();
        log.info("===== main end =====");
    }
}
