package com.ibusiness.businessweb.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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



@Entity
@Table(name = "businessman")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BusinessmanEntity  implements Serializable{	
	 @Id
	 int id;
	 
	 String name;
	 
	 @Column(name = "phone_number")
	 String phoneNumber;
	 
	 
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "contact"/*, insertable =  false, updatable = false*/)
	 Products contactEntity;
	 
}
