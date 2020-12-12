package com.ibusiness.businessweb.dto;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BusinessmanAllDetailsDto {	

	 int name;
	 BigInteger phone_number;
	 private String email;
	 private String website ;
	 private int businessowner;
	 private String horCoordinates;
	 private String verCoordinates;

}
