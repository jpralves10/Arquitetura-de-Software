package com.livro.ofertas.gubee.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void salvarDados(String chave, String valor) {
        redisTemplate.opsForValue().set(chave, valor);
    }

    public String buscarDados(String chave) {
        return redisTemplate.opsForValue().get(chave);
    }

    public String buscarKeys() {
        return redisTemplate.keys("*").toString();
    }
}
