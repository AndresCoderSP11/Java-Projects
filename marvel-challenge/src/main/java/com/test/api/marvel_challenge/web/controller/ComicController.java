package com.test.api.marvel_challenge.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comics")
public class ComicController {

    @GetMapping
    public ResponseEntity<List<ComicDto>> findAll(
            @RequestParam(required = false) Long characterId,
            @RequestParam(defaultValue = "0") long offset,
            @RequestParam(defaultValue = "10") long limit
    ){

    }




}
