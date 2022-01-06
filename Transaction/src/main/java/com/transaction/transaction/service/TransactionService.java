package com.transaction.transaction.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.transaction.model.Transaction;
import com.transaction.transaction.transactionrepository.TransactionRepository;

/**
 * Service layer for Transaction.
 * @author prath
 *
 */
@Service
public class TransactionService {

	Logger log = LoggerFactory.getLogger(TransactionService.class);
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	/**
	 * Method to find transaction by Id.
	 * @param tranId
	 * @return  
	 */
	public Optional<Transaction> getTransactionById(Integer tranId) {
		return transactionRepository.findById(tranId);
	}
	
	
	/**
	 * Update account balance and add new transaction
	 * @param tran
	 * @return Transaction
	 */
	public Transaction addTransaction(Transaction tran) {
		log.info("Adding new transaction and adjusting account balance");
		if(tran.getType().equals("Credit")) {
			double temp = tran.getAccount().getAccountBal();
			temp = temp + tran.getAmt();
			tran.getAccount().setAccountBal(temp);
			transactionRepository.save(tran);
			return tran;
		}
		else if(tran.getType().equals("Debit")) {
			double temp = tran.getAccount().getAccountBal();
			temp = temp - tran.getAmt();
			tran.getAccount().setAccountBal(temp);
			transactionRepository.save(tran);
			return tran;
		}
		else {
			log.warn("Invalid Transaction Type");
			return null;
		}}
	
	/**
	 * Method to delete a failed transaction and revert account balance
	 * @param tran
	 */
	public void deletefailedTransaction(Integer tranId) {
		if(transactionRepository.existsById(tranId)) {
		Transaction tran = transactionRepository.getById(tranId);
		if(tran.getType() == "Credit") {
			double temp = tran.getAccount().getAccountBal();
			temp = temp - tran.getAmt();
			tran.getAccount().setAccountBal(temp);
			transactionRepository.deleteById(tranId);
			
		}else if(tran.getType() == "Debit") {
			double temp = tran.getAccount().getAccountBal();
			temp = temp + tran.getAmt();
			tran.getAccount().setAccountBal(temp);
			transactionRepository.deleteById(tranId);
		}}
		else
		{
		log.warn("Transaction with Id" +tranId + "does not exist.");	
	}}
	
	
	/**
	 * List out all the transaction
	 * @return List of Transactions
	 */
	public List<Transaction> getTransactions(){
		log.info("getting all the transactions");
		return transactionRepository.findAll();
	}
	
}