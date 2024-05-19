package com.leticia.bookStore.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<> ();

    public ValidationError() {
        super ();
    }

    public ValidationError(Long timestemp, Integer status, String error) {
        super (timestemp, status, error);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addErrors(String fieldName, String message) {
        this.errors.add (new FieldMessage (fieldName, message));
    }
}
