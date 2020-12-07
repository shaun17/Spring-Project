package thread;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.Exchanger;

public class UseExchange {
    static Exchanger ex = new Exchanger();
    private static final Log log = LogFactory.getLog(UseExchange.class);
    public static void main(String[] args) {
        new Thread(()->{
            log.info(Thread.currentThread().getName());
            Object exchange = null;
            try {
                exchange = ex.exchange(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.warn(exchange.toString() +"-"+ Thread.currentThread().getName());
        }).start();

        new Thread(()->{
            log.info(Thread.currentThread().getName());
            Object exchange = null;
            try {
                exchange = ex.exchange(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.warn(exchange.toString() +"-"+ Thread.currentThread().getName());
        }).start();
    }
}
