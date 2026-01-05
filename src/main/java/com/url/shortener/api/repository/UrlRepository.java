package com.url.shortener.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.url.shortener.api.model.Url;

@Repository
public interface UrlRepository extends MongoRepository<Url, String>{
    
}
