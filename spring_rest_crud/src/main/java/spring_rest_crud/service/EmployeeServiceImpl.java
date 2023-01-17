package spring_rest_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_rest_crud.dao.EmployeeDao;
import spring_rest_crud.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeDao empDao;
	@Override
	public Employee createEmployee(Employee employee) {
		
		Employee emp=empDao.createEmployee(employee);
		return emp;
		
		
	}
	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return empDao.getEmployee(id);
	}
	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return empDao.getEmployee();
	}
	@Override
	public Employee updateEmployee(Employee employee) {
		return empDao.updateEmployee( employee);
	}
	@Override
	public int deleteEmp(int id) {
		
		return empDao.deleteEmp(id);
	}
	@Override
	public List<Employee> getAllEmployeeByDeptAndName(String deptName, String name) {
		// TODO Auto-generated method stub
		return empDao.getAllEmployeeByDeptAndName(deptName,name);
	}


}
