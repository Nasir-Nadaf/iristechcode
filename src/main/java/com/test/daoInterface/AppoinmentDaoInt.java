package com.test.daoInterface;

import java.util.List;

import com.test.entitys.Appoinment;

public interface AppoinmentDaoInt {
	public String setAppointment(Appoinment appointment);
	public List<Appoinment> getAllAppointment();
}
