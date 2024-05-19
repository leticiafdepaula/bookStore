package com.leticia.bookStore.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FieldMessage implements Serializable {
    private static final long SerialVersionUID = 1l;

    private String fieldName;
    private String message;
    public FieldMessage () {
        super();
    }

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }


}
