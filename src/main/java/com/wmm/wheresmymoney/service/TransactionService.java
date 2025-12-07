package com.wmm.wheresmymoney.service;

import com.wmm.wheresmymoney.dto.transactionDto.TransactionCreateDTO;
import com.wmm.wheresmymoney.model.Transaction;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TransactionService {

    Transaction createTransaction(TransactionCreateDTO transactionCreateDTO);
}
