package thread;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public class UseCyclicBarrier {
    private static final Log log = LogFactory.getLog(UseCyclicBarrier.class);
    static CyclicBarrier cb = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception{
        log.info("===== main start =====");
        log.info("***** foreach[4] start *****");
        IntStream.rangeClosed(1, 5).boxed().forEach(x -> {
            new Thread(() -> {
                try {
                    cb.await();
                    log.warn(" got it ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        });
        Thread.sleep(1000);
        log.info("***** foreach[4] end *****");
        Long now = System.currentTimeMillis();
        while (cb.getNumberWaiting()!=0){
            log.info("***** keep wait *****");
            Thread.sleep(500);
            if(System.currentTimeMillis() - now >5000){
                log.info("***** time over *****");
                return;
            }
        }
        log.info("===== main end =====");
    };

}
