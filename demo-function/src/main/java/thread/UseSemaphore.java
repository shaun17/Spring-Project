package thread;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class UseSemaphore {
    private static final Log log = LogFactory.getLog(UseSemaphore.class);
    private static final Semaphore sp = new Semaphore(3);

    public static void main(String[] args) {
        IntStream.rangeClosed(1,10).boxed().forEach(x->{
            new Thread(()->{
                try {
                    //计数
                    sp.acquire();
                    log.info(x);
                    Thread.sleep(1000);
                    //释放
                    sp.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        });
    }
}
