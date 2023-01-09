package com.furkan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tbluser")
@Entity
public class UserEntity {
@Id
private long id;

@Column(unique = true, nullable = false)
private String username;

private String email;


}
