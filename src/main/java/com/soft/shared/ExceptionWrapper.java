package com.soft.shared;

import com.google.common.base.Preconditions;

public class ExceptionWrapper extends RuntimeException{
    
    private final String userFriendlyMessage;

    public ExceptionWrapper(String message){
        this.userFriendlyMessage = message;
    }

    public ExceptionWrapper(String message, Exception cause){
        this.userFriendlyMessage = message;
        Preconditions.checkNotNull(cause);
        this.initCause(cause);
    }

    public String getUserFriendlyMessage(){
        return this.userFriendlyMessage;
    }
}
