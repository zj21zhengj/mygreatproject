package com.org.seckill.exception;

//所有秒杀异常
public class SeckillException extends RuntimeException{

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public SeckillException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

}
