package com.ibusiness.businessweb.repositories;

import java.math.BigInteger;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibusiness.businessweb.entity.BusinessmanAllDetails;
import com.ibusiness.businessweb.entity.BusinessmanEntity;
import com.ibusiness.businessweb.entity.Products;

public interface BusinessmanContactRepository extends JpaRepository <Products,Integer>{
	
		
}