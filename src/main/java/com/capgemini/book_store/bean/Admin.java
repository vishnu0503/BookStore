package com.capgemini.book_store.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Admin")
public class Admin {

	@Id
	@GeneratedValue(generator="admin",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="admin",sequenceName="admin123",initialValue=100,allocationSize=1)
	private int adminId;
	
	@Size(max = 64)
	private String email;
	
	@Size(max = 30)
	private String fullName;
	
	@Size(max = 16)
	private String password;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
