package com.bank.demo.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TransmitDTO {
	@JsonProperty(value = "transaction_id")
	private int id;
	
	@JsonProperty(value = "receiver_id")
	private int receiver;
	
	@JsonProperty(value = "amount")
	private double amount;
}
