package com.bank.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.demo.controller.dto.TransactionPostDTO;
import com.bank.demo.controller.mapper.UserMapper;
import com.bank.demo.entity.Transaction;
import com.bank.demo.service.TransactionService;

import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transactions")
public class TransactionController {
	private final TransactionService transactionServ;
	private final UserMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<TransactionPostDTO>>  getAllTrasnactions() {
		List<TransactionPostDTO> transListDto = new ArrayList<>();
		
		List<Transaction> transList = transactionServ.findAll();
		
		transList.forEach(t -> {
			transListDto.add(mapper.toTransPostDto(t));
		});
		
		return new ResponseEntity<List<TransactionPostDTO>>(transListDto, HttpStatus.OK);
	}
}
