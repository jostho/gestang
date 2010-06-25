package org.jostho.topper.domain;

import java.util.Date;

import org.springframework.util.ObjectUtils;

public class Employee {

	private int id;
	
	private String firstName;
	private String lastName;
	private String email;
	private String designation;
	private Date dateOfJoining;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [ ") ;
		builder.append(id).append(" | ");
		builder.append(firstName).append(" | ");
		builder.append(lastName).append(" | ");
		builder.append(email).append(" | ");
		builder.append(designation).append(" | ");
		builder.append(dateOfJoining);
		builder.append(" ]") ;
		
		return builder.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Employee) {
			return equals((Employee)obj);
		}
		
		return false;
	}
	
	protected boolean equals(Employee employee) {
		return 
		  ( this.getId() == employee.getId() &&
		    ObjectUtils.nullSafeEquals(this.getFirstName(), employee.getFirstName()) &&
		    ObjectUtils.nullSafeEquals(this.getLastName(), employee.getLastName()) && 
		    ObjectUtils.nullSafeEquals(this.getEmail(), employee.getEmail()) && 
		    ObjectUtils.nullSafeEquals(this.getDesignation(), employee.getDesignation()) && 
		    ObjectUtils.nullSafeEquals(this.getDateOfJoining(), employee.getDateOfJoining())		
		  );
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
