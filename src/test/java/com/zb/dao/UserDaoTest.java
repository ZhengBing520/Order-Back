package com.zb.dao;

import com.zb.common.Constant;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

/**
 * Created by bzheng on 2019/1/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class UserDaoTest {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    @Ignore
    public void md5() {
        /*String s = DigestUtils.md5DigestAsHex(Constant.DEFAULT_PWD.getBytes());
        System.out.println(s.toUpperCase());//DC483E80A7A0BD9EF71D8CF973673924*/
    }

    @Test
    public void testRedis() {
        redisTemplate.opsForValue().set("zb", "zz");
        Object zb = redisTemplate.opsForValue().get("zb");
        System.out.println(zb);
    }
}
