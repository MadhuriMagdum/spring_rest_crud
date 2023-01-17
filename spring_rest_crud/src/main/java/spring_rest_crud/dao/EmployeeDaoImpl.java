package spring_rest_crud.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring_rest_crud.globalException.EmployeeNotAvailableException;
import spring_rest_crud.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private static final Object department = null;
	@Autowired
	SessionFactory factory;

	@Override
	public Employee createEmployee(Employee employee) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Serializable save = session.save(employee);
		Employee emp = session.get(Employee.class, save);
		tx.commit();
		return emp;
	}

	@Override
	public Employee getEmployee(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Employee emp = session.get(Employee.class, id);
		if (null == emp)
			throw new EmployeeNotAvailableException("employee not available for id " + id);
		tx.commit();
		return emp;
	}

	@Override
	public List<Employee> getEmployee() {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		List<Employee> empList = session.createQuery(" from Employee").list();
		tx.commit();
		return empList;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(employee);
		Employee emp = session.get(Employee.class, employee.getId());
		tx.commit();
		return emp;
	}

	@Override
	public int deleteEmp(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(session.get(Employee.class, id));
		tx.commit();
		return id;
	}

	@Override
	public List<Employee> getAllEmployeeByDeptAndName(String deptName, String name) {
		System.out.println("dao........");
		List<Employee> empList = null;
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("from Employee e where e.department.deptName = :deptName and e.name =: name");
		query.setParameter("deptName", deptName);
		query.setParameter("name", name);
		empList = query.list();

		if (empList.isEmpty() | empList == null)
			throw new EmployeeNotAvailableException("Employee not present in that kind  ....." + deptName + "......"+name);

		tx.commit();
		return empList;
	}

}
