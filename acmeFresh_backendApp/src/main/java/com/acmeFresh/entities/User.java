package com.acmeFresh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(length = 10, nullable = false)
	private String userName;

	@Column(nullable = false)
	private String userEmail;

	@Column(nullable = false)
	private String userPassword;

}
