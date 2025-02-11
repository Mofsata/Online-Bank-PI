package com.bank.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.demo.controller.dto.TransactionGetDTO;
import com.bank.demo.entity.Account;
import com.bank.demo.entity.Transaction;
import com.bank.demo.service.AccountService;
import com.bank.demo.service.TransferService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transfers")
public class TransferController {

	private final AccountService accServ;
	private final TransferService transServ;

	@PostMapping
	public ResponseEntity<String> postMethodName(@RequestBody TransactionGetDTO dto) {
		Account src = accServ.findOneAcc(dto.getSender());
		Account dest = accServ.findOneAcc(dto.getReceiver());
		Transaction trans = new Transaction();
		trans.setSender(src);
		trans.setReceiver(dest);
		trans.setAmount(dto.getAmount());
		transServ.transfer(trans);
		return ResponseEntity.ok("Transfer Done Successfully");
	}

}
