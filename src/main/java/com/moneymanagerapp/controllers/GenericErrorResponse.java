package com.moneymanagerapp.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericErrorResponse {

    private final String errorMessage;
    private final String innerExceptionErrorMessage;
    private final int errorCode;
}
