package org.hsl.sample_api.advice;

import lombok.extern.slf4j.Slf4j;
import org.hsl.sample_api.controller.UserController;
import org.hsl.sample_api.exception.BaseFailException;
import org.hsl.sample_api.exception.NoUserDataException;
import org.hsl.sample_api.notification.NotificationManager;
import javax.validation.ConstraintViolationException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class ControllerAdvice {

    @Autowired
    NotificationManager notificationManager;

    @ExceptionHandler(value = {NoUserDataException.class})
    public ResponseEntity noUserDataExceptionHandler(RuntimeException e) {
        notificationManager.sendNotification(ExceptionUtils.getStackTrace(e));
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity illegalArgumentExceptionHandler(RuntimeException e) {
        notificationManager.sendNotification(ExceptionUtils.getStackTrace(e));
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity constraintViolationExceptionHandler(RuntimeException e) {
        notificationManager.sendNotification(ExceptionUtils.getStackTrace(e));
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {BaseFailException.class})
    public ResponseEntity notModifiedExceptionHandler(RuntimeException e) {
        notificationManager.sendNotification(ExceptionUtils.getStackTrace(e));
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_MODIFIED);
    }
}
