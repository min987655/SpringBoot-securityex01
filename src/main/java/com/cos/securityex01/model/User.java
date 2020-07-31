package com.cos.securityex01.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

// ORM - Object Relation Mapping

@Data
@Entity // 자바오브젝트 토대로 테이블 생성하여 매핑해 줌
public class User {
	@Id // id PK 걸어주는 어노테이션
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 넘버링 전략 사용하는 DB의 전략 따라가겠음
	private int id;
	private String username;
	private String password;
	private String email;
	@CreationTimestamp
	private Timestamp createDate;
}
