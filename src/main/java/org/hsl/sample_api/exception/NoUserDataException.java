package org.hsl.sample_api.exception;

public class NoUserDataException extends RuntimeException {

    public NoUserDataException() {
        super((Throwable) null);
    }

    public NoUserDataException(String msg) {
        super(msg, null);
    }
}
