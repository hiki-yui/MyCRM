package com.zs.hiki.settings.domain.Exception;

public class NotHaveLoginNameException extends LoginException {
    public NotHaveLoginNameException() {
        super();
    }

    public NotHaveLoginNameException(String message) {
        super(message);
    }
}
