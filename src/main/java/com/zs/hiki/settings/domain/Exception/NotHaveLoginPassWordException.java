package com.zs.hiki.settings.domain.Exception;

public class NotHaveLoginPassWordException extends LoginException {
    public NotHaveLoginPassWordException() {
        super();
    }

    public NotHaveLoginPassWordException(String message) {
        super(message);
    }
}
