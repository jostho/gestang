package org.jostho.topper.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.jostho.topper.domain.Employee;
import org.springframework.jdbc.core.RowMapper;

/*
 * Dao Impl backed by database
 */
public class EmployeeDaoImpl extends AbstractEmployeeDao implements EmployeeDao {

	@Override
	public int add(Employee employee) {
		Object[] args = getArgsForInsert(employee) ;
		int rowsAffected = jdbcTemplate.update(pscFactory.newPreparedStatementCreator(args), keyHolder) ;
		
		if(rowsAffected > 0) {
			return keyHolder.getKey().intValue();	
		} else {
			return rowsAffected;
		}
	}

	@Override
	public int delete(int id) {
		Object[] args = new Object[] {id};
		int rowsAffected = jdbcTemplate.update(deleteSql, args) ;		
		return rowsAffected;
	}

	@Override
	public Employee get(int id) {
		Object[] args = new Object[] {id};
		Employee employee = jdbcTemplate.queryForObject(selectSql, args, new EmployeeMapper()) ;
		return employee;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> employees = jdbcTemplate.query(selectAllSql, new EmployeeMapper()) ;
		return employees;
	}

	@Override
	public int update(Employee employee) {
		Object[] args = getArgsForUpdate(employee) ;
		int rowsAffected = jdbcTemplate.update(updateSql, args) ;		
		return rowsAffected;
	}


	/*
	 * Inner class to map Employee object
	 */
	private static final class EmployeeMapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Employee employee = new Employee() ;
			employee.setId(resultSet.getInt("id")) ;
			employee.setFirstName(resultSet.getString("first_name")) ;
			employee.setLastName(resultSet.getString("last_name")) ;
			employee.setEmail(resultSet.getString("email")) ;
			employee.setDesignation(resultSet.getString("designation")) ;
			employee.setDateOfJoining(resultSet.getDate("date_of_joining")) ;
			return employee;
		}
		
	}
	
}



