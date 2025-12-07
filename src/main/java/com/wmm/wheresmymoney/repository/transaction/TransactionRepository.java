package com.wmm.wheresmymoney.repository.transaction;

import com.wmm.wheresmymoney.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
