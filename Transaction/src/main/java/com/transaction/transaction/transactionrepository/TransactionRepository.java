package com.transaction.transaction.transactionrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.transaction.model.Transaction;

/**
 * @author prath
 * Repository
 */

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
