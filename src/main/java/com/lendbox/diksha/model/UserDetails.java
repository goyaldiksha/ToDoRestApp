package com.lendbox.diksha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserDetails {
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", id=" + id + ", pass=" + pass + "]";
	}
	
	
	@Id
	@GeneratedValue
	private Integer id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String pass;
	
	public UserDetails(){}
	
	public UserDetails(String name, String email, Integer id, String pass) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
