package com.test.entitys;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;


@Component
public class Appoinment {
	
	private String docName;
	private String hospitalName;
	private Date appointmentDate;
	private String time;
	private String timeRequire;
	
	
	public Appoinment(@NotNull(message = "Doctor name is required")String docName, @NotNull(message = "Hospital name is required")String hospitalName, Date appointmentDate, String time, String timeRequire) {
		super();
		this.docName = docName;
		this.hospitalName = hospitalName;
		this.appointmentDate = appointmentDate;
		this.time = time;
		this.timeRequire = timeRequire;
	}
	

	public Appoinment() {
		super();
	}


	public String getDocName() {
		return docName;			
	}

	public void setDocName(String docName) {
		this.docName = docName;		//sir here was the issue i dint wirte this keyword
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;  //sir here was the issue i dint wirte this keyword
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTimeRequire() {
		return timeRequire;
	}

	public void setTimeRequire(String timeRequire) {
		this.timeRequire = timeRequire;
	}

	@Override
	public String toString() {
		return "Appoinment [DocName=" + docName + ", HospitalName=" + hospitalName + ", appointmentDate="
				+ appointmentDate + ", time=" + time + ", timeRequire=" + timeRequire + "]";
	}
	

}
