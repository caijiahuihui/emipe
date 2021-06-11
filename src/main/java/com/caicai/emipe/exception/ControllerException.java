package com.caicai.emipe.exception;

import lombok.Data;

/**
 * @author caicai
 * @create 2021/6/10
 */
@Data
public class ControllerException extends RuntimeException {
    private static final long serialVersionUID = 7070452713149902275L;

    public ControllerException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    private String code;

    private String message;

}
