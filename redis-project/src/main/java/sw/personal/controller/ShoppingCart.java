package sw.personal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ShoppingCart {

    private final String userid = UUID.randomUUID().toString().replace("-", "");

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/addcart")
    public void addCart(int i){
        String proId = UUID.randomUUID().toString().replace("-", "");
        redisTemplate.opsForHash().put(userid,proId, i);
    }
    @GetMapping("/cart")
    public List cart(int i){
        return  redisTemplate.opsForHash().values(i);
    }
    @GetMapping("/delcart")
    public Long delCart(String proId){
        Long delete = redisTemplate.opsForHash().delete(userid, proId);
        return delete;
    }

}
