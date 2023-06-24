package com.test.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entitys.Appoinment;
import com.test.service.AppointmentService;
import com.test.serviceInterface.AppoinmentServiceInte;

@RestController
@RequestMapping(value="/app")
public class AppointmentController {
	@Autowired
	private AppoinmentServiceInte service;
	
	@PostMapping(value="/set-appointment")
	public ResponseEntity<String> setappointment(@Valid @RequestBody Appoinment appoinment) {
		//System.out.println(appoinment);
		String msg=service.setAppointment(appoinment);
		if(msg!=null) {
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}	
	}
	
	@GetMapping(value="/get-all-appointment")
	public List<Appoinment> getAllAppointment(){
		List<Appoinment> list=service.getAllAppointment();
		return list;
		
	}

}
