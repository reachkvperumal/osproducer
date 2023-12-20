package com.kv.os.thread.demo.producer.controller;

import com.kv.os.thread.demo.producer.exception.ProducerException;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;


@Log4j2
@RestController
@RequestMapping("/api/v1")
public class Produzentin {

    @GetMapping("/sleep/{secs}")
    public ResponseEntity<String> demo(@PathVariable("secs") Integer secs) {
        log.info("Thread to sleep for {} seconds", secs);
        try {
            Thread.sleep(Duration.ofSeconds(secs));
        } catch (InterruptedException e) {
            String message = ExceptionUtils.getRootCauseMessage(e);
            log.error("InterruptedException with details {}", message);
            throw new ProducerException(message);
        }
        return new ResponseEntity<>("Success!", HttpStatus.OK);
    }

    @GetMapping("/exp")
    public String exception(){
        throw new ProducerException("Test for log");
    }
}
