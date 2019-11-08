package com.gisdev01.grass.cricket;


import com.gisdev01.grass.cricket.model.Cricket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1/cricket")
public class CricketResource {

    private CricketRepository cricketRepository;

    public CricketResource(CricketRepository cricketRepository) {
        this.cricketRepository = cricketRepository;
    }

    @GetMapping("/add/{id}/{name}")
    public Cricket add(@PathVariable("id") final String id,
                       @PathVariable("name") final String name) {
        cricketRepository.save(new Cricket(id, name, "MD5FROMWEBINSERT"));
        return cricketRepository.findById(id);
    }

    @GetMapping("/update/{id}/{name}")
    public Cricket update(@PathVariable("id") final String id,
                          @PathVariable("name") final String name) {
        cricketRepository.update(new Cricket(id, name, "MD5FROMWEBUPDATE"));
        return cricketRepository.findById(id);
    }

    @GetMapping("/delete/{id}")
    public Map<String, Cricket> delete(@PathVariable("id") final String id) {
        cricketRepository.delete(id);
        return all();
    }

    @GetMapping("/get/{id}")
    public Cricket get(@PathVariable("id") final String id) {
        return cricketRepository.findById(id);
    }

    @GetMapping("/all")
    public Map<String, Cricket> all() {
        return cricketRepository.findAll();
    }
}
