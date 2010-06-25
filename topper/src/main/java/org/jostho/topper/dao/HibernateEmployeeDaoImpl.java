package org.jostho.topper.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.jostho.topper.domain.Employee;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * An alternate DAO implementation using Hibernate  
 *
 */
public class HibernateEmployeeDaoImpl implements EmployeeDao {

	private HibernateTemplate hibernateTemplate ;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory) ;
	}
	
	@Override
	public int add(Employee employee) {
		Integer id = (Integer) hibernateTemplate.save(employee) ;
		return id.intValue();
	}

	@Override
	public int delete(int id) {
		
		Employee employee = getEmployeeForDelete(id) ;
		
		hibernateTemplate.delete(employee) ;
		return 1;
	}

	@Override
	public Employee get(int id) {
		return hibernateTemplate.get(Employee.class, new Integer(id)) ;
	}

	@Override
	public List<Employee> getAll() {
		return hibernateTemplate.find("from Employee") ;
	}

	@Override
	public int update(Employee employee) {
		hibernateTemplate.update(employee) ;
		return 1;
	}

	/*
	 * Prepare Employee object for delete
	 */
	private Employee getEmployeeForDelete(int id ) {
		
		// read the object from DB
		//Employee employee = get(id) ;
		
		Employee employee = new Employee() ;
		employee.setId(id) ;
		
		return employee ;
	}
	
}
