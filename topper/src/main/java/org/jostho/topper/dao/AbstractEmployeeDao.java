package org.jostho.topper.dao;

import javax.sql.DataSource;

import org.jostho.topper.domain.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.KeyHolder;

public abstract class AbstractEmployeeDao {

	protected JdbcTemplate jdbcTemplate;
	protected PreparedStatementCreatorFactory pscFactory;
	protected KeyHolder keyHolder;
	
	protected String selectSql;
	protected String selectAllSql;
	protected String updateSql;
	protected String deleteSql;
		

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource) ;
	}

	public void setPscFactory(PreparedStatementCreatorFactory pscFactory) {
		this.pscFactory = pscFactory;
	}
	
	public void setKeyHolder(KeyHolder keyHolder) {
		this.keyHolder = keyHolder;
	}
	
	public void setSelectSql(String selectSql) {
		this.selectSql = selectSql;
	}

	public void setSelectAllSql(String selectAllSql) {
		this.selectAllSql = selectAllSql;
	}

	public void setUpdateSql(String updateSql) {
		this.updateSql = updateSql;
	}

	public void setDeleteSql(String deleteSql) {
		this.deleteSql = deleteSql;
	}

	
	protected Object[] getArgsForInsert(Employee employee) {		
		return new Object[] {
			employee.getFirstName(), 
			employee.getLastName(),
			employee.getEmail(),
			employee.getDesignation(),
			employee.getDateOfJoining()
		} ;
	}

	protected Object[] getArgsForUpdate(Employee employee) {		
		return new Object[] {
			employee.getFirstName(), 
			employee.getLastName(),
			employee.getEmail(),
			employee.getDesignation(),
			employee.getDateOfJoining(),
			employee.getId()
		} ;
	}

}