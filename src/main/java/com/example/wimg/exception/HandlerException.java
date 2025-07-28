package com.example.wimg.exception;

import com.example.wimg.entity.exception.ErrorMessageDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HandlerException {
    private static final Logger logger =
            LoggerFactory.getLogger(HandlerException.class);

    @ExceptionHandler(value = GenericException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorMessageDTO handleException(GenericException ex) {
        logger.error("Generic Error: " + ex.getMessage());
        return new ErrorMessageDTO(ex.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ErrorMessageDTO handleException(Exception ex) {
        logger.error("Internal error: " + ex.getMessage());
        return new ErrorMessageDTO(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        logger.info("Bad Request: " + ex.getMessage());
        List<ErrorMessageDTO> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String validation = "";
            for (String code : Arrays.stream(error.getCodes()).toList()) {
                validation += " " + code;
            }
            errors.add(new ErrorMessageDTO(validation + " : " + error.getDefaultMessage()));
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}