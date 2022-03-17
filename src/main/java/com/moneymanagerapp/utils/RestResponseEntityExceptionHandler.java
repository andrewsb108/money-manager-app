package com.moneymanagerapp.utils;

import com.moneymanagerapp.controllers.GenericErrorResponse;
import com.moneymanagerapp.exceptions.CategoryAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({CategoryAlreadyExistException.class})
    public ResponseEntity<GenericErrorResponse> handleCategoryAlreadyExistException(Exception e,
                                                                                    WebRequest request) {
        GenericErrorResponse errorResponse = buildErrorResponse(e.getMessage());
        log.error("event=CategoryAlreadyExistException={}, errorResponse={}, request={}", errorResponse, e, request);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private static GenericErrorResponse buildErrorResponse(String errorMessage) {
        return GenericErrorResponse.builder()
                .errorCode(AppConstants.CATEGORY_CREATING_ERROR)
                .errorMessage(errorMessage)
                .build();
    }
}
