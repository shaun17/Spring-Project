package sw.personal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sw.personal.service.RedisLock;
import sw.personal.service.RedisLockLuaScript;

import java.util.UUID;

/**
 * @Author wenrenhao
 * @Date 2020-11-29 11:33
 * @Version 1.0
 */
@RestController
public class LockController {
    private final static Logger log = LoggerFactory.getLogger(LockController.class);
    private final static String uuid = UUID.randomUUID().toString();

    @Autowired
    RedisLock lock;

    @Autowired
    RedisLockLuaScript lockLuaScript;

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("lock")
    public void lock() {
        String name = Thread.currentThread().getName();
        long id = Thread.currentThread().getId();
        boolean lock_ = lock.lockBlock("lock_key", uuid, 10000);
        log.info("当前lock对象为:"+lock+"，线程名称:"+name+",线程id："+id+",获取锁状态为："+lock_);

    }
    @GetMapping("dellock")
    public void dellock() {
        String name = Thread.currentThread().getName();
        long id = Thread.currentThread().getId();
        boolean lock_ = lock.unlock("lock_key", uuid);
        log.info("当前lock对象为:"+lock+"，线程名称:"+name+",线程id："+id+",删除锁状态为："+lock_);

    }



    @GetMapping("lualock")
    public void lualock() {
        String name = Thread.currentThread().getName();
        long id = Thread.currentThread().getId();
        boolean lock_ = lockLuaScript.getLock("lualock_key", uuid);
        log.info("当前lock对象为:"+lock+"，线程名称:"+name+",线程id："+id+",获取锁状态为："+lock_);

    }
    @GetMapping("dellualock")
    public void dellualock() {
        String name = Thread.currentThread().getName();
        long id = Thread.currentThread().getId();
        boolean lock_ = lockLuaScript.releaseLock("lualock_key", uuid);
        log.info("当前lock对象为:"+lock+"，线程名称:"+name+",线程id："+id+",删除锁状态为："+lock_);

    }
}
