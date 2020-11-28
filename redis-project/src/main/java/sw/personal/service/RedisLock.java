package sw.personal.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class RedisLock {

    @Autowired
    private StringRedisTemplate redis;

    private static final Long RELEASE_SUCCESS = 1L;
    private static final long DEFAULT_TIMEOUT = 1000 * 10;
    private static final String UNLOCK_LUA = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";


    public boolean lockBlock(String key, String value, long timeout) {
        long start = System.currentTimeMillis();
        while (true) {
            //检测是否超时
            if (System.currentTimeMillis() - start > timeout) {
                return false;
            }
            //执行set命令，底层为jedis的字节码操做
            //1
            Boolean absent = redis.opsForValue().setIfAbsent(key, value, timeout, TimeUnit.MILLISECONDS);
            //其实没必要判NULL，这里是为了程序的严谨而加的逻辑
            if (absent == null) {
                return false;
            }
            //是否成功获取锁
            if (absent) {
                return true;
            }
        }
    }
    public boolean unlock(String key, String value) {

        DefaultRedisScript<Long> longDefaultRedisScript = new DefaultRedisScript<>(UNLOCK_LUA, Long.class);
        Long result  = redis.execute(longDefaultRedisScript,
                Collections.singletonList(key),// KEYS[1]
                value // ARGV[1]  删除KEY的标识
                //  String.valueOf(expireTimeMilliseconds) // ARGV[2]   过期时间
        );

        //返回最终结果
        return RELEASE_SUCCESS.equals(result);
    }}
