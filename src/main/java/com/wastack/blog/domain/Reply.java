package com.wastack.blog.domain;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Setter;
@Entity
@Table(name="reply")
@Data
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int replyindex;
	
	@Column(nullable=false)
	private int boardindex;
	
	@Column(nullable=false)
	private int userindex;
	
	@Column(nullable=false)
	private String title;

	@Column(nullable=false)
	private String contents;
	
	@Column(nullable=false)
	private Date registerdate=new Date();
}
