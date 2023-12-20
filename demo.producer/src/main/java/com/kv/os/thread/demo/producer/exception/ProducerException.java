package com.kv.os.thread.demo.producer.exception;

public class ProducerException extends RuntimeException{
    public ProducerException() {
    }
    public ProducerException(String message) {
        super(message);
    }

    public ProducerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProducerException(Throwable cause) {
        super(cause);
    }

    public ProducerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
