package com.furkan.entity;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class User {
	private String name;
	private String lastName;
	private String email;
	private String password;

}
