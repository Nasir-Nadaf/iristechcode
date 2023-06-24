package com.test.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.AppointmentDao;
import com.test.daoInterface.AppoinmentDaoInt;
import com.test.entitys.Appoinment;
import com.test.serviceInterface.AppoinmentServiceInte;

@Service
public class AppointmentService implements AppoinmentServiceInte {
	
	@Autowired
	private AppoinmentDaoInt dao;
	@Autowired
	ServletContext context;
	
	public  List<String> readDoctor(){ //this method will give Dr names from file
		List<String> list=new ArrayList<>();
		String realPath = context.getRealPath("resources");
		System.out.println(realPath);
		try {
			FileInputStream fis=new FileInputStream(realPath+"/Doctor.xlsx");
			Workbook workbook=new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> row = sheet.rowIterator();
			while(row.hasNext()) {
				Row rows = row.next();
				Iterator<Cell> cell = rows.cellIterator();
				while(cell.hasNext()) {
					Cell cells = cell.next();
					CellType cellType = cells.getCellType();
					if(cellType==cellType.STRING) {
						list.add(cells.getStringCellValue());
					}
					
				}
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		list.add("Kulkarni");
//		list.add("Naresh");
//		list.add("Rahul");
//		list.add("Nitin");
		
		return list;
		
	}
	public  List<String> readHospital(){ //this method will give hospital names from file
		List<String> list=new ArrayList<>();
		String realPath = context.getRealPath("resources");
		System.out.println(realPath);
		try {
			FileInputStream fis=new FileInputStream(realPath+"/Hospital.xlsx");
			Workbook workbook=new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> row = sheet.rowIterator();
			while(row.hasNext()) {
				Row rows = row.next();
				Iterator<Cell> cell = rows.cellIterator();
				while(cell.hasNext()) {
					Cell cells = cell.next();
					CellType cellType = cells.getCellType();
					if(cellType==cellType.STRING) {
						list.add(cells.getStringCellValue());
					}
					
				}
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		list.add("LifePoint");
//		list.add("Phoenix");
//		list.add("sahyadri");
//		list.add("Rubby Hall");
		return list;
	}
	@Override
	public String setAppointment(Appoinment appointment) {
		List<String> listDoctor = this.readDoctor();
		List<String> listHospital=this.readHospital();
		Boolean checkDoctor=false;
		Boolean checkHospital=false;
		String msg = null;
		for (String hospital : listHospital) {
			if(appointment.getHospitalName().equals(hospital)) {
				checkHospital=true;
			}
		}
		for (String doctor : listDoctor) {
			if(appointment.getDocName().equals(doctor)) {
				checkDoctor=true;
			}
		}
		//System.out.println(checkDoctor+" "+checkHospital);
		if(checkDoctor && checkHospital) {
			 msg=dao.setAppointment(appointment);
		}else {
			msg="no such Doctor or Hospital present";
		}
		
		
		return msg;
	}
	@Override
	public List<Appoinment> getAllAppointment() {
		// TODO Auto-generated method stub
		return dao.getAllAppointment();
	}
	

}
