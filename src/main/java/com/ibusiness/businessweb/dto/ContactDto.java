package com.ibusiness.businessweb.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContactDto {

	 private int id;
	 private String email;
	 private String socialMediaAccount ;
	 private String horCoordinates;
	 private String verCoordinates;
}
