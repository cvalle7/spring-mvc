package com.formacion.nttdata.crud.servicio;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.formacion.nttdata.crud.dto.Employee;

@Service
public class CrudService {

	public void setFechaActual(Employee employee) {
		Date date = Calendar.getInstance().getTime();
        employee.setDate(date);
	}
	
	
}
