package com.bank.demo.entity;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Users")
public class User {
	@Id
	@Column(name = "User_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Basic
	@Column(name = "Full_Name")
	private String fullName;

	@Basic
	@Column(name = "phone_number",unique = true)
	private long phone;

	@Basic
	@Column(name = "national_id",unique = true)
	private String nationalId;

	@OneToMany(
			mappedBy = "user", 
			fetch = FetchType.EAGER, 
			orphanRemoval = true
			)
	private List<Account> accounts;
}
