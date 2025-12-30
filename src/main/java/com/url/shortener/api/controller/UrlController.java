package com.url.shortener.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/url")
public class UrlController {
    

    @GetMapping(path = "/{id}")
    public ResponseEntity<String> getUrlById(@PathVariable String id) {
        return new ResponseEntity<String>("", HttpStatus.MOVED_PERMANENTLY);
    }

    
}
