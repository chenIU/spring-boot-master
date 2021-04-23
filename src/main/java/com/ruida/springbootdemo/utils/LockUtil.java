package com.ruida.springbootdemo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Chen.J.Y
 * @date 2021/4/21
 */
@Slf4j
@Component
public class LockUtil {

    private static final String LOCK_PREFIX = "LOCK:";

    private static final String LOCK_SUCCESS = "true";

    private static final int DEFAULT_EXPIRE_TIME = 30;

    private static final String DEFAULT_VALUE = "default_value";

    private static RedisTemplate<String, Object> redisTemplate;

    @Resource
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        LockUtil.redisTemplate = redisTemplate;
    }

    /**
     * 尝试获取锁
     *
     * @param lockKey     锁key
     * @param requiredId  锁value
     * @param expireTime  过期时间（秒）
     * @param tryCount    尝试次数
     * @param sleepMillis 休眠时间（毫秒）
     * @return
     */
    public static boolean tryLock(String lockKey, String requiredId, int expireTime, int tryCount, long sleepMillis) {
        for (int i = 0; i < tryCount; i++) {
            boolean lock = lock(lockKey, requiredId, expireTime);
            if (lock) {
                return true;
            } else {
                try {
                    Thread.sleep(sleepMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    /**
     * 不添加请求id，不安全，不推荐
     *
     * @param lockKey 锁key
     * @return
     */
    public static boolean lock(String lockKey) {
        return lock(lockKey, DEFAULT_VALUE, DEFAULT_EXPIRE_TIME);
    }

    /**
     * 不添加请求id，不安全，不推荐
     *
     * @param lockKey    锁key
     * @param expireTime 过期时间
     * @return
     */
    public static boolean lock(String lockKey, int expireTime) {
        return lock(lockKey, DEFAULT_VALUE, expireTime);
    }

    /**
     * 采用默认时间的分布式获取锁
     *
     * @param lockKey    锁key
     * @param requiredId 锁value
     * @return
     */
    public static boolean lock(String lockKey, String requiredId) {
        return lock(lockKey, requiredId, DEFAULT_EXPIRE_TIME);
    }

    public static boolean lock(String lockKey, String requiredId, int expireTime) {
        try {

            Boolean result = redisTemplate.execute((RedisCallback<Boolean>) connection ->
                    connection.set((LOCK_PREFIX + lockKey).getBytes(),
                            requiredId.getBytes(),
                            Expiration.from(expireTime, TimeUnit.SECONDS),
                            RedisStringCommands.SetOption.SET_IF_ABSENT));

            return result != null && LOCK_SUCCESS.equals(result.toString());
        } catch (Exception e) {
            log.error("获取锁失败,key=[{}],requireId=[{}]", lockKey, requiredId);
            return false;
        }
    }

    /**
     * 释放锁
     *
     * @param lockKey    锁key
     * @param requiredId 锁value
     * @return
     */
    public static boolean releaseLock(String lockKey, String requiredId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        DefaultRedisScript<Long> defaultRedisScript = new DefaultRedisScript<>(script, Long.class);
        List<String> keys = new ArrayList<>();
        keys.add(LOCK_PREFIX + lockKey);

        try {
            Long result = redisTemplate.execute(defaultRedisScript, new StringRedisSerializer(), new RedisSerializer<Long>() {
                @Override
                public byte[] serialize(Long aLong) throws SerializationException {
                    return aLong == null ? null : aLong.toString().getBytes(StandardCharsets.UTF_8);
                }

                @Override
                public Long deserialize(byte[] bytes) throws SerializationException {
                    return bytes == null ? null : Long.parseLong(new String(bytes, StandardCharsets.UTF_8));
                }
            }, keys, requiredId);

            if (result == null) return false;

            return result > 0;
        } catch (Exception e) {
            log.error("释放锁失败,key = [{}],requiredId = [{}]", lockKey, requiredId, e);
            return false;
        }
    }

    /**
     * 释放锁（不安全，不推荐）
     *
     * @param lockKey
     * @return
     */
    public static boolean releaseLock(String lockKey) {
        return releaseLock(lockKey, DEFAULT_VALUE);
    }
}
