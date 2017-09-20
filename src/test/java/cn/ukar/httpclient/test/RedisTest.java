package cn.ukar.httpclient.test;

import cn.ukar.redis.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jyou on 2017/9/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext*.xml")
public class RedisTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void test(){
        redisService.add("key", "value1");
    }

}
