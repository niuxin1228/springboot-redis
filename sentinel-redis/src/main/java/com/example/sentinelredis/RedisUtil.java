package com.example.sentinelredis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis方法类
 */

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private RedisSerializer<String> stringSerializer = new StringRedisSerializer();

    public RedisUtil() {
    }

    @PostConstruct
    public void init() {
        this.redisTemplate.setKeySerializer(this.stringSerializer);
        this.redisTemplate.setValueSerializer(this.stringSerializer);
        this.redisTemplate.setHashKeySerializer(this.stringSerializer);
        this.redisTemplate.setHashValueSerializer(this.stringSerializer);
    }

    public boolean set(final String key, String value) {
        boolean result = false;

        try {
            this.redisTemplate.opsForValue().set(key, value);
            result = true;
            return result;
        } catch (Exception var5) {
            throw new IllegalArgumentException(var5);
        }
    }

    public boolean set(final String key, String value, Long expireTime) {
        boolean result = false;

        try {
            ValueOperations<Serializable, Object> operations = this.redisTemplate.opsForValue();
            operations.set(key, value);
            this.redisTemplate.expire(key, expireTime, TimeUnit.MILLISECONDS);
            result = true;
            return result;
        } catch (Exception var6) {
            throw new IllegalArgumentException(var6);
        }
    }

    public void remove(final String... keys) {
        String[] var2 = keys;
        int var3 = keys.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String key = var2[var4];
            this.remove(key);
        }

    }

    public void removePattern(final String pattern) {
        Set<String> keys = this.getKeys(pattern);
        if (!keys.isEmpty()) {
            this.redisTemplate.delete(keys);
        }

    }

    public void remove(final String key) {
        if (this.exists(key)) {
            this.redisTemplate.delete(key);
        }

    }

    public boolean exists(final String key) {
        return this.redisTemplate.hasKey(key);
    }

    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = this.redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    public Set<String> getKeys(String key) {
        key = "*" + key + "*";
        return this.stringRedisTemplate.keys(key);
    }

    public void hmSet(String key, Object hashKey, Object value) {
        HashOperations<String, Object, Object> hash = this.redisTemplate.opsForHash();
        hash.put(key, hashKey, value);
    }

    public void hmSet(String key, Object hashKey, Object value, Long expireTime) {
        HashOperations<String, Object, Object> hash = this.redisTemplate.opsForHash();
        hash.put(key, hashKey, value);
        this.redisTemplate.expire(key, expireTime, TimeUnit.MILLISECONDS);
    }

    public Object hmGet(String key, Object hashKey) {
        HashOperations<String, Object, Object> hash = this.redisTemplate.opsForHash();
        return hash.get(key, hashKey);
    }

    public void lPush(String k, Object v) {
        ListOperations<String, Object> list = this.redisTemplate.opsForList();
        list.rightPush(k, v);
    }

    public List<Object> lRange(String k, long l, long l1) {
        ListOperations<String, Object> list = this.redisTemplate.opsForList();
        return list.range(k, l, l1);
    }

    public void add(String key, Object value) {
        SetOperations<String, Object> set = this.redisTemplate.opsForSet();
        set.add(key, new Object[]{value});
    }

    public Set<Object> setMembers(String key) {
        SetOperations<String, Object> set = this.redisTemplate.opsForSet();
        return set.members(key);
    }

    public void zAdd(String key, Object value, double score) {
        ZSetOperations<String, Object> zset = this.redisTemplate.opsForZSet();
        zset.add(key, value, score);
    }

    public Set<Object> rangeByScore(String key, double score, double score1) {
        ZSetOperations<String, Object> zset = this.redisTemplate.opsForZSet();
        return zset.rangeByScore(key, score, score1);
    }
}

