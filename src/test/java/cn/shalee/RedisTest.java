package cn.shalee;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 23:17
 * @注释
 */
@SpringBootTest
public class RedisTest {

    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void testSet() {
        //往redis中存储一个键值对
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();

        operations.set("username","张三");
    }
}
