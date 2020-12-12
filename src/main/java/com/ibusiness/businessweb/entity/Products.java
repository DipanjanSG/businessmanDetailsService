package com.ibusiness.businessweb.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "businessman_contact")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@Builder
public class Products  implements Serializable{
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	 
	 @Column
	 private String email;
	 
	 @Column(name = "social_media_acc")
	 private String socialMediaAccount ;
	 
	 @Column(name = "hor_coordinates")
	 private String horCoordinates;
	 
	 @Column(name = "ver_coordinates")
	 private String verCoordinates;
	 

}
