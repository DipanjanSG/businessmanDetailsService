package com.ibusiness.businessweb.controllers;

import java.math.BigInteger;


import java.util.List;
import javax.jms.Queue;
import javax.jms.Topic;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.ibusiness.businessweb.dto.BusinessmanDto;
import com.ibusiness.businessweb.messaging.producer.Producer;
import com.ibusiness.businessweb.services.BusinessmanService;

@RestController()
@RequestMapping("/businessmen/v1")
public class BusinessmanController {

	@Autowired
	private BusinessmanService businessmanService;
	
//	@Autowired
//	RestTemplate restTemplate;
	
	@Autowired
	JmsTemplate jmsTemplate;

	
	@Autowired
	Producer producer;
	
	@GetMapping("/{id}") 
	public ResponseEntity<BusinessmanDto> getBusinessman(@PathVariable int id) {
		
//		String url = "http://localhost:8081/businesses/v1/1";
//		BusinessmanDto x = restTemplate.getForObject(url, BusinessmanDto.class);
//		System.out.println(x);
		producer.sendBusinessmanIdToMQ(id);
		return new ResponseEntity<>(businessmanService.getBusinessemenById(id),HttpStatus.OK);
	}
	
//	@GetMapping("/findBusinessmanAllDetails/v1/{id}")
//	public ResponseEntity<BusinessmanDto> findBusinessmanAllDetails(@PathVariable int id) {
//		return new ResponseEntity<>(businessmanService.getAllDetailsOfBusinessemen(id),HttpStatus.OK);
//	} 
		
	@GetMapping("/phoneNumber/{phoneNumber}")
	public ResponseEntity<BusinessmanDto> findBusinessmanByPhNumber(@PathVariable String phoneNumber) {
		return new ResponseEntity<>(businessmanService.getBusinessemenByPhNum(phoneNumber),HttpStatus.OK);
	} 
//	
//	@GetMapping("/findTotalBusiness")
//	public ResponseEntity<Integer> getTotalNumberOfBusinesses() {
//		return new ResponseEntity<>(getAllBusinesses().getBody().size(),HttpStatus.OK);
//	} 
//	
	@PostMapping("/")
	public ResponseEntity<HttpHeaders> createNewBusiness(@RequestBody BusinessmanDto businessmanDto) {
		
		businessmanDto = businessmanService.createNewBusiness(businessmanDto);
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.add("Location","/createBusiness"+String.valueOf(businessmanDto.getId()));
		
		return new ResponseEntity<>(httpHeader,HttpStatus.CREATED);
	} 
//	
//	@PutMapping("/updateBusiness/{id}")
//	public ResponseEntity<HttpHeaders> updateBusiness(@PathVariable int id, @RequestBody Contact location) {
//		Contact updatedLocation = locationService.updateBusiness(location);
//		if (updatedLocation == null)
//				return new ResponseEntity(HttpStatus.NO_CONTENT);
//		HttpHeaders httpHeader = new HttpHeaders();
//		httpHeader.add("Updated "+ location.getId(),"/createBusiness"+updatedLocation.toString());
//		return new ResponseEntity<>(httpHeader,HttpStatus.OK);
//	}
//
//	@PutMapping("/deleteBusiness/{businessNumber}")
//	public ResponseEntity<HttpHeaders> deleteBusiness(@PathVariable int businessNumber) {
//		locationService.deleteBusiness(businessNumber);
//		HttpHeaders httpHeader = new HttpHeaders();
//		
//		if ( locationService.getByBusinessNumber(businessNumber) == null ) {
//			httpHeader.add("Deleted ", "business id " +businessNumber);
//			return new ResponseEntity<>(httpHeader,HttpStatus.NO_CONTENT);
//			
//		}
//		
//		httpHeader.add("Not Deleted ", "business id " +businessNumber);
//		return new ResponseEntity<>(httpHeader,HttpStatus.OK);		
//	}
	
}
