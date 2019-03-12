package com.wastack.blog.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="board")
@Data
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer boardindex;
	
	@Column(nullable=false)
	private String title;

	@Column(nullable=false)
	private String contents;
	
	@Column
	private String tag;
	
	@Column(nullable=false)
	private Date registerdate=new Date();
	
	
}
