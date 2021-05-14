package com.zs.hiki.settings.domain.Exception;

public abstract class LoginException extends RuntimeException {
    LoginException() {
        super();
    }

    LoginException(String message) {
        super(message);
    }
}
