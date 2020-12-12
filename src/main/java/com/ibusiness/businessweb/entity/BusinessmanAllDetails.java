package com.ibusiness.businessweb.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BusinessmanAllDetails  implements Serializable{	

	static final long serialVersionUID = 42L;
	
	 int name;
	 BigInteger phone_number;
	 private String email;
	 private String website ;
	 private int businessowner;
	 private String horCoordinates;
	 private String verCoordinates;

}
