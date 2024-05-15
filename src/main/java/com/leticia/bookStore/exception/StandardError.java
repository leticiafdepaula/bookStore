package com.leticia.bookStore.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandardError {

    private long timesTamp;
    private Integer status;
    private String errorMessage;

    public StandardError() {
       super();
    }


    public StandardError(long timesTamp, Integer status, String errorMessage) {
        super();
        this.timesTamp = timesTamp;
        this.status = status;
        this.errorMessage = errorMessage;
    }
}
