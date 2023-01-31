package com.bookingservice.dto;

import com.bookingservice.entities.BookingEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookMainReq {

	private BookingEntity bookingData;
}
