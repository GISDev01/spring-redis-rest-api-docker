package com.gisdev01.grass.cricket;

import com.gisdev01.grass.cricket.model.Cricket;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CricketRepositoryImpl implements CricketRepository {

    private RedisTemplate<String, Cricket> redisTemplate;

    private HashOperations hashOperations;
    private String KEY_PREFIX = "CRICKET:";

    public CricketRepositoryImpl(RedisTemplate<String, Cricket> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Cricket cricket) {
        hashOperations.put(cricket.getKey(), cricket.getId(), cricket);
    }

    @Override
    public Map<String, Cricket> findAll() {
        return hashOperations.entries('*');
    }

    @Override
    public Cricket findById(String id) {
        return (Cricket)hashOperations.get(KEY_PREFIX+id, id);
    }

    @Override
    public void update(Cricket cricket) {
        save(cricket);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY_PREFIX+id, id);
    }
}
