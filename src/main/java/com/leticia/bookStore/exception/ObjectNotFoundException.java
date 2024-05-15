package com.leticia.bookStore.exception;

public class ObjectNotFoundException extends RuntimeException {

    private static long serialversionUID = 1L;

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

   public ObjectNotFoundException(String message){
        super(message);
   }

}
