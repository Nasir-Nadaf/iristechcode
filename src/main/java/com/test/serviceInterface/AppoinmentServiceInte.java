package com.test.serviceInterface;

import java.util.List;

import com.test.entitys.Appoinment;

public interface AppoinmentServiceInte {
	public String setAppointment(Appoinment appointment);
	public List<Appoinment> getAllAppointment();

}
