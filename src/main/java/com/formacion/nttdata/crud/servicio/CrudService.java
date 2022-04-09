package com.formacion.nttdata.crud.servicio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.nttdata.crud.dto.Employee;

@Service
public class CrudService {

	@Autowired
	private Validator validator;
	
	public void setFechaActual(Employee employee) {
		Date date = Calendar.getInstance().getTime();
        employee.setDate(date);
	}
	
	public Optional<List<String>> validEmployee(Employee employee) {
		
		List<String> errores = new ArrayList<String>();
		
		Set<ConstraintViolation<Employee>> validation = validator.validate(employee);
		
		if(!validation.isEmpty()) {
			
			for (ConstraintViolation<Employee> constraintViolation : validation) {
				errores.add(constraintViolation.getPropertyPath().toString() + " " + constraintViolation.getMessage());
			}
			
			return Optional.of(errores);
		}
		
		setFechaActual(employee);
		
		return Optional.empty();
	}
}
