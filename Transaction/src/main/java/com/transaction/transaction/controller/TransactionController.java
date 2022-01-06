package com.transaction.transaction.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.transaction.model.Transaction;
import com.transaction.transaction.service.TransactionService;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping(value = "/getbyid")
	public Optional<Transaction> findTransactionById(@RequestBody Integer transactionId) {
		return transactionService.getTransactionById(transactionId);
	}
	
	@PostMapping
	public Transaction addNewTransaction(@RequestBody Transaction tran) {
		return transactionService.addTransaction(tran);
	}
	
	@GetMapping
	public List<Transaction> getAllTransactions() {
		return transactionService.getTransactions();
	}
	
	@DeleteMapping
	public void deleteTransaction(@RequestBody Integer transId) {
		transactionService.deletefailedTransaction(transId);
	}
	
}
