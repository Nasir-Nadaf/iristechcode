package com.test.dao;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.test.daoInterface.AppoinmentDaoInt;
import com.test.entitys.Appoinment;

@Repository
public class AppointmentDao implements AppoinmentDaoInt {
	List<Appoinment> appointments=new ArrayList<>();
	AppointmentDao() {

//		Appoinment aa=new Appoinment("nasir", "abc", new Date("2023-02-01T18:30:00.000+00:00"), "13:00", "2Hr");
//		appointments.add(aa);
		
	}
	@Override
	public String setAppointment(Appoinment appointment) {
		System.out.println(appointment);
		String msg=null;
		if(appointments.isEmpty()&&appointment.getAppointmentDate().getDay()!=Calendar.SUNDAY) {
			appointments.add(appointment);
			msg="appoinment schedule successfully....";
		}else {
			for (Appoinment appoinment1 : appointments) {
				
				if(!appointment.getDocName().equals(appoinment1.getDocName()) &&
					appointment.getAppointmentDate().getDate()!=(appoinment1.getAppointmentDate().getDate())) {

					appointments.add(appointment);
					msg="appoinment schedule successfully....";
					System.out.println(msg);
				}else {
					msg="Doctor have another appointment today";
					System.out.println(msg);
					
				}
			
		}
		
		}
		return msg;
	}
	@Override
	public List<Appoinment> getAllAppointment() {
		// TODO Auto-generated method stub
		return appointments;
	}

}
