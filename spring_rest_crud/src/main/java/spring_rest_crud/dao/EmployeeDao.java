package spring_rest_crud.dao;

import java.util.List;

import spring_rest_crud.model.Employee;

public interface EmployeeDao {

	Employee createEmployee(Employee employee);

	Employee getEmployee(int id);

	List<Employee> getEmployee();

	Employee updateEmployee(Employee employee);

	int deleteEmp(int id);

	List<Employee> getAllEmployeeByDeptAndName(String deptName, String name);


		
}
