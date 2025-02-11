package com.bank.demo.service;

import org.springframework.stereotype.Service;

import com.bank.demo.entity.Account;
import com.bank.demo.entity.Transaction;
import com.bank.demo.repository.AccountsRepository;
import com.bank.demo.repository.TransactionRepository;
import com.bank.demo.service.exception.InsufficientBalanceException;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransferService {
	private final TransactionRepository transRepo;
	private final AccountsRepository accountRepo;

	@Transactional
	public Transaction transfer(Transaction transaction) {
		Account src = transaction.getSender();
		Account dist = transaction.getReceiver();
		
		if (src.getBalance() < transaction.getAmount()) {
			throw new InsufficientBalanceException("Current balance: " + src.getBalance() + " is insufficient.");
		}

		src.setBalance(src.getBalance() - transaction.getAmount());
		dist.setBalance(dist.getBalance() + transaction.getAmount());
		accountRepo.save(src);
		accountRepo.save(dist);
		return transRepo.save(transaction);
	}

}
