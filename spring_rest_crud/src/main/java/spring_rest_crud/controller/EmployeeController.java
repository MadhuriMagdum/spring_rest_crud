package spring_rest_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring_rest_crud.globalException.InSufficientDetailException;
import spring_rest_crud.model.Employee;
import spring_rest_crud.service.EmployeeService;

@Controller
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@PostMapping("/employees")
	public @ResponseBody Employee createEmp(@RequestBody Employee employee) {
		if(employee.getId()==0|employee.getName()==null|employee.getDepartment()==null) {
			throw new InSufficientDetailException("you entered insufficient data to create new employee");
		}
		Employee emp= empService.createEmployee(employee);
		return emp;
	}
	@DeleteMapping("/employees/{id}")
	public @ResponseBody int deleteEmp(@PathVariable ("id")int id) {
		int i= empService.deleteEmp(id);
		return i;
	}
	
	@GetMapping("/employees/{id}")
	public  @ResponseBody Employee getEmployee(@PathVariable("id") int id) {
	return empService.getEmployee(id);
	}
	
	@GetMapping("/employees")
	public  @ResponseBody List<Employee> getEmployee() {
		return empService.getEmployee();
	}
	
	@PutMapping("/employees")
	public @ResponseBody   Employee updateEmployee(@RequestBody Employee employee) {
		Employee emp= empService.updateEmployee(employee);
		return emp;
	}
	@GetMapping("/employees1")

	public  @ResponseBody List<Employee> getAllEmployeeByDeptAndName(@RequestParam ("deptName") String deptName,@RequestParam ("name")String name) {
		 return empService.getAllEmployeeByDeptAndName(deptName, name);
		
	}

}
