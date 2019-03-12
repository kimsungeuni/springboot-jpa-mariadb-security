package com.wastack.blog.domain;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.Setter;
@Entity
@Table(name="users")
@Data
public class User {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userindex;
	
	@Column(nullable=false,unique=true)
	private String email;
	
	@Column(nullable=false)
	private String password;

	@Column(nullable=false,unique=true)
	private String nicname;
	
	@Column(nullable=false)
	private Date registerdate=new Date();
	
	@Column(nullable=false)
	//@Enumerated(EnumType.STRING)
	private Integer role=2;
	
	
	
}
