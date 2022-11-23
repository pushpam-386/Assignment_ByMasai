package com.push.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
	
	private String houseOrApartment;
	private String landmark;
	private String district;
	private String state;
	private String pincode;

}
