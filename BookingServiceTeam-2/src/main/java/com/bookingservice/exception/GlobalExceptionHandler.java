package com.bookingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(FareNotPresent.class)
	public ResponseEntity<ApiResponseForExceptions> fareNotPresentExceptionHandle(FareNotPresent message){
		String msg = message.getMessage();
		ApiResponseForExceptions apiResponce = new ApiResponseForExceptions(msg,false);
		return new ResponseEntity<ApiResponseForExceptions>(apiResponce,HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}
	
	@ExceptionHandler(FlightDoesNotExits.class)
	public ResponseEntity<ApiResponseForExceptions> flightDoesNotExitsExceptionalHandler(FlightDoesNotExits message){
		String msg = message.getMessage();
		ApiResponseForExceptions apiResponse = new ApiResponseForExceptions(msg,false);
		return new ResponseEntity<ApiResponseForExceptions>(apiResponse,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SeatsNotAvailable.class)
	public ResponseEntity<ApiResponseForExceptions> seatsNotAvailableExceptionHandler(SeatsNotAvailable message){
		String msg = message.getMessage();
		ApiResponseForExceptions apiResponse = new ApiResponseForExceptions(msg,false);
		return new ResponseEntity<ApiResponseForExceptions>(apiResponse,HttpStatus.INSUFFICIENT_STORAGE);
	}
}
