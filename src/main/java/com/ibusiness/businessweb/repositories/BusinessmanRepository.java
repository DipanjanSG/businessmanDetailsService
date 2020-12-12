package com.ibusiness.businessweb.repositories;

import java.math.BigInteger;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibusiness.businessweb.entity.BusinessmanAllDetails;
import com.ibusiness.businessweb.entity.BusinessmanEntity;
import com.ibusiness.businessweb.entity.Products;

public interface BusinessmanRepository extends JpaRepository <BusinessmanEntity,Integer>{
	
	@Query("select a from BusinessmanEntity a where a.phoneNumber = :phoneNumber")
	public BusinessmanEntity findBusinessByPhoneNumber(String phoneNumber);
	
	//@Query("select b,c from BusinessmanEntity b inner join b.contactDetails c where b.id = :id")
	@Query("select b from BusinessmanEntity b where b.id = :id")
	public BusinessmanAllDetails findAllDetailsBusinessman(int id);
		
}