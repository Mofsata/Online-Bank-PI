package com.bank.demo.controller.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserDTO {
//	@JsonProperty(value = "user_id")
//	private int id;
	
	@JsonProperty(value = "full_name")
	private String fullName;
	
	@JsonProperty(value = "phone_number")
	private long phone;
	
	@JsonProperty(value = "national_id")
	private String nationalId;
	
	@JsonProperty(value = "accounts")
	private List<AccountDTO> accounts;
}
