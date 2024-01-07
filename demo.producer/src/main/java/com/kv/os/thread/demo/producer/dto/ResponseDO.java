package com.kv.os.thread.demo.producer.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDO {
    private Integer code;
    private String data;
}
