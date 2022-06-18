package com.springboot.apivalidation.advice;

import com.springboot.apivalidation.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus (HttpStatus.BAD_REQUEST)
    @ExceptionHandler (MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArguments(MethodArgumentNotValidException methodArgumentNotValidException) {

        List<FieldError> fieldErrors = methodArgumentNotValidException
                .getBindingResult()
                .getFieldErrors();

        Map<String, String> errorMap = fieldErrors.stream()
                .collect(Collectors.toMap(fieldError -> fieldError.getField(), FieldError::getDefaultMessage));

        return errorMap;
    }

    @ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler (UserNotFoundException.class)
    public Map<String, String> handleBusinessException(UserNotFoundException userNotFoundException) {

        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("Error", userNotFoundException.getMessage());
        return errorMap;
    }
}
