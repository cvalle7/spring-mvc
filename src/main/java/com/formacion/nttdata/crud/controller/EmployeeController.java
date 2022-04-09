package com.formacion.nttdata.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.formacion.nttdata.crud.dao.EmployeeMapper;
import com.formacion.nttdata.crud.dto.Employee;
import com.formacion.nttdata.crud.servicio.CrudService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	CrudService service;

	@Autowired
	EmployeeMapper employeeMapper;
	private static final String EMPLOYEE = "Employee";
	private static final String EMPLOYEELIST = "ListEmployees";

	@RequestMapping("/listOfEmployee")
	public String showListOfEmployees(Model model) {
		model.addAttribute("employeeList", employeeMapper.getAllEmployees());
		return EMPLOYEELIST;
	}

	@RequestMapping("/showFormForAdd")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return EMPLOYEE;
	}

	@RequestMapping("/saveProcess")
	public String saveEmployee(@ModelAttribute("employee") Employee employee, Model model) {

		Optional<List<String>> listaErrores = service.validEmployee(employee);

		if (!listaErrores.isPresent()) {
			if (employee.getId() == null) {
				employeeMapper.saveEmployee(employee);
			} else {
				employeeMapper.updateEmployee(employee);
			}
			return "redirect:/employee/listOfEmployee";
		}

		model.addAttribute("errores", listaErrores.get());
		
		return EMPLOYEE;
	}

	@RequestMapping("/displayUpdateForm")
	public String showUpdateForm(@RequestParam("employeeId") int employeeId, Model model) {
		model.addAttribute("employee", employeeMapper.findById(employeeId));
		return EMPLOYEE;
	}

	@RequestMapping("/displayDeleteForm")
	public String deleteEmployee(@RequestParam("employeeId") int employeeId) {
		employeeMapper.deleteEmployee(employeeId);
		return "redirect:/employee/listOfEmployee";
	}
}
