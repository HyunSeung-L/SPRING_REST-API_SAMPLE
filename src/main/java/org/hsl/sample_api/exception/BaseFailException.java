package org.hsl.sample_api.exception;

abstract public class BaseFailException extends RuntimeException {

    public BaseFailException() {
        super((Throwable) null);
    }

    public BaseFailException(String msg) {
        super(msg, null);
    }

}
