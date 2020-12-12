package com.ibusiness.businessweb.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ibusiness.businessweb.entity.Products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BusinessmanDto {
	
	 private int id;
	 private String name;
	 private String phoneNumber;
	 private ContactDto contactEntity;

	
}
