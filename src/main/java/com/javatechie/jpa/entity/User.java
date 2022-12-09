package com.javatechie.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor

@Data
@ToString
@Entity
@Table(name="USER_TBL")
public class User {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="user_name")
	private String userName;
	private String password;
	private String email;
	@Column(name="is_active")
	private boolean isActive;
	private String type;
	public User(String userName, String password, 
			String email, boolean isActive,String type) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.isActive = isActive;
		this.type=type;
	}
	
	
}
