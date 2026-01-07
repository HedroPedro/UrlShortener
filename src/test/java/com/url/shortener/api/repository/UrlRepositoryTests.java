package com.url.shortener.api.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.mongodb.test.autoconfigure.DataMongoTest;

import com.url.shortener.api.model.Url;

//@DataMongoTest
public class UrlRepositoryTests {
    
    /*@Autowired
    private UrlRepository repository;*/

    @BeforeAll
    public void setup() {
        Url url = new Url("aa", "bb");
        //repository.save(url);
    }

    /*@Test
    public void testFindUrlById() {
        Url newUrl = repository.findById("aa").get();
    
        assertEquals("bb", newUrl.getUrl());
    }

    @Test
    public void testSizeEqual1() {
        assertEquals(1, repository.count());
    }*/
}
