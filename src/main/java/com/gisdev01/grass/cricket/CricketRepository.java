package com.gisdev01.grass.cricket;

import com.gisdev01.grass.cricket.model.Cricket;

import java.util.Map;

public interface CricketRepository {

    void save(Cricket cricket);
    Map<String, Cricket> findAll();
    Cricket findById(String id);
    void update(Cricket cricket);
    void delete(String id);
}
