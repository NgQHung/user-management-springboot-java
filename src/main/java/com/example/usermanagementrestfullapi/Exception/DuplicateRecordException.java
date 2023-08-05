package com.example.usermanagementrestfullapi.Exception;

public class DuplicateRecordException extends RuntimeException {
    public DuplicateRecordException (String message){
        super(message);
    }

}
