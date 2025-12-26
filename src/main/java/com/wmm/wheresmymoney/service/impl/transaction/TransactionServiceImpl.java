package com.wmm.wheresmymoney.service.impl.transaction;

import com.wmm.wheresmymoney.dto.transactionDto.TransactionCreateDTO;
import com.wmm.wheresmymoney.dto.transactionDto.TransactionUpdateDTO;
import com.wmm.wheresmymoney.mapper.transaction.TransactionMapper;
import com.wmm.wheresmymoney.model.Transaction;
import com.wmm.wheresmymoney.model.User;
import com.wmm.wheresmymoney.repository.transaction.TransactionRepository;
import com.wmm.wheresmymoney.repository.user.UserRepository;
import com.wmm.wheresmymoney.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void deleteTransaction(int id){
        transactionRepository.findById(id)
                .orElseThrow(() ->  new RuntimeException("Id de transação inexistente"));

        transactionRepository.deleteById(id);
    }

    @Override
    public List<Transaction> findAllTransactionByUserId(int userId){
        return transactionRepository.findAllTransactionByUserId(userId);
    }

    @Override
    public Transaction updateTransaction(TransactionUpdateDTO transactionUpdateDTO){
        Transaction transaction = transactionRepository.findById(transactionUpdateDTO.getId())
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));

        transaction.setAmount(transactionUpdateDTO.getAmount());
        transaction.setDescription(transactionUpdateDTO.getDescription());
        transaction.setType(transactionUpdateDTO.getType());
        transaction.setCategory(transactionUpdateDTO.getCategory());
        transaction.setDateTransaction(transactionUpdateDTO.getDateTransaction());

        return transactionRepository.save(transaction);
    }
}
