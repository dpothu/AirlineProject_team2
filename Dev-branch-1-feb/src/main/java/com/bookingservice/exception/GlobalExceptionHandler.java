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
	
	@ExceptionHandler(PassengerCountDetails.class)
	public ResponseEntity<ApiResponseForExceptions> passengersDetailsMismatch(PassengerCountDetails message){
		String msg = message.getMessage();
		ApiResponseForExceptions apiResponse = new ApiResponseForExceptions(msg,false);
		return new ResponseEntity<ApiResponseForExceptions>(apiResponse,HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(CheckSourceAndDestination.class)
	public ResponseEntity<ApiResponseForExceptions> checkSourceAndDestinationExceptionHandler(CheckSourceAndDestination message){
		String msg = message.getMessage();
		ApiResponseForExceptions apiResponse = new ApiResponseForExceptions(msg,false);
		return new ResponseEntity<ApiResponseForExceptions>(apiResponse,HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(CheckDepartDate.class)
	public ResponseEntity<ApiResponseForExceptions> checkDepartDateExceptionHandler(CheckDepartDate message){
		String msg = message.getMessage();
		ApiResponseForExceptions apiResponse = new ApiResponseForExceptions(msg,false);
		return new ResponseEntity<ApiResponseForExceptions>(apiResponse,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(CheckArrAndDepartDate.class)
	public ResponseEntity<ApiResponseForExceptions> checkArrAndDepartDateExceptionHandler(CheckArrAndDepartDate message){
		String msg = message.getMessage();
		ApiResponseForExceptions apiResponse = new ApiResponseForExceptions(msg,false);
		return new ResponseEntity<ApiResponseForExceptions>(apiResponse,HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(CheckArrAndDepartTime.class)
	public ResponseEntity<ApiResponseForExceptions> checkArrAndDepartTimeExceptionHandler(CheckArrAndDepartTime message){
		String msg = message.getMessage();
		ApiResponseForExceptions apiResponse = new ApiResponseForExceptions(msg,false);
		return new ResponseEntity<ApiResponseForExceptions>(apiResponse,HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(CheckDepartTime.class)
	public ResponseEntity<ApiResponseForExceptions> checkDepartTimeExceptionHandler(CheckDepartTime message){
		String msg = message.getMessage();
		ApiResponseForExceptions apiResponse = new ApiResponseForExceptions(msg,false);
		return new ResponseEntity<ApiResponseForExceptions>(apiResponse,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(BookingIdNotFound.class)
	public ResponseEntity<ApiResponseForExceptions> bookIdNotPresent(BookingIdNotFound message){
		String msg = message.getMessage();
		ApiResponseForExceptions apiResponse = new ApiResponseForExceptions(msg,false);
		return new ResponseEntity<ApiResponseForExceptions>(apiResponse,HttpStatus.NOT_FOUND);
	}
}
