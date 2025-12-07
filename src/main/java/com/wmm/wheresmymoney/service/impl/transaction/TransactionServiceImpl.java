package com.wmm.wheresmymoney.service.impl.transaction;

import com.wmm.wheresmymoney.dto.transactionDto.TransactionCreateDTO;
import com.wmm.wheresmymoney.mapper.transaction.TransactionMapper;
import com.wmm.wheresmymoney.model.Transaction;
import com.wmm.wheresmymoney.model.User;
import com.wmm.wheresmymoney.repository.transaction.TransactionRepository;
import com.wmm.wheresmymoney.repository.user.UserRepository;
import com.wmm.wheresmymoney.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    public TransactionServiceImpl(
            TransactionRepository transactionRepository,
            UserRepository userRepository
    ){
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Transaction createTransaction(TransactionCreateDTO transactionCreateDTO) {
        User user = userRepository.findById(transactionCreateDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Transaction transaction = TransactionMapper.toEntity(transactionCreateDTO, user);

        return transactionRepository.save(transaction);
    }
}
