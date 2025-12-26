package com.wmm.wheresmymoney.service;

import com.wmm.wheresmymoney.dto.transactionDto.TransactionCreateDTO;
import com.wmm.wheresmymoney.dto.transactionDto.TransactionUpdateDTO;
import com.wmm.wheresmymoney.model.Transaction;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface TransactionService {

    Transaction createTransaction(TransactionCreateDTO transactionCreateDTO);

    void deleteTransaction(int id);

    List<Transaction> findAllTransactionByUserId(int userId);

    Transaction updateTransaction(TransactionUpdateDTO transactionUpdateDTO);
}
