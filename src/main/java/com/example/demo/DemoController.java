package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@Slf4j
@RequestMapping(value = "/demo")
public class DemoController {
    @GetMapping(value = "/random", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Integer> generateRandom() {
        return ResponseEntity.ok(randomNumberGenerate());
    }

    @GetMapping(value = "/random/{max}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Integer> generateRandom(@PathVariable int max) {
        return ResponseEntity.ok(randomNumberGenerate(max));
    }

    private int randomNumberGenerate() {
        Random rand = new Random();
        return rand.nextInt(100);
    }

    private int randomNumberGenerate(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }
}
