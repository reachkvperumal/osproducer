package com.kv.os.thread.demo.producer.controller;

import com.kv.os.thread.demo.producer.dto.IncidentDO;
import com.kv.os.thread.demo.producer.dto.ResponseDO;
import com.kv.os.thread.demo.producer.exception.ProducerException;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Log4j2
@RestController
@RequestMapping("/api/v1")
public class Produzentin {

    @GetMapping("/sleep/{secs}")
    public ResponseEntity<String> demo(@PathVariable("secs") Integer secs) {
        try {
            Thread.sleep(Duration.ofSeconds(secs));
            log.info("Thread Name: {}",Thread.currentThread());
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

    @PostMapping(value = "/portal",produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDO> portalNotification(@RequestHeader("x-request-id") Optional<String> header, @RequestBody IncidentDO incidentDO){
        log.info("Header: {} - Notification Received: {}", Optional.ofNullable(header).get().orElseGet(() -> "NULL"), incidentDO);
        return ResponseEntity.ok(ResponseDO.builder().code(200).data("SUCCESS").build());
    }

    @PostMapping("/outbound")
    public String demo(@RequestHeader("x-request-id") Optional<String> header, @RequestBody String incidentDO){
        log.info("Header: {} - Notification Received: {}", Optional.ofNullable(header).get().orElseGet(() -> "NULL"), incidentDO);
        return "Success";
    }
}

