package com.wmm.wheresmymoney.mapper.transaction;

import com.wmm.wheresmymoney.dto.transactionDto.TransactionCreateDTO;
import com.wmm.wheresmymoney.dto.transactionDto.TransactionResponseDTO;
import com.wmm.wheresmymoney.model.Transaction;
import com.wmm.wheresmymoney.model.User;

public class TransactionMapper {

    public static Transaction toEntity(TransactionCreateDTO transactionCreateDTO, User user){
        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setAmount(transactionCreateDTO.getAmount());
        transaction.setDescription(transactionCreateDTO.getDescription());
        transaction.setDateTransaction(transactionCreateDTO.getDateTransaction());
        return transaction;
    }

    public static TransactionResponseDTO toResponseDTO(Transaction transaction){
        return new TransactionResponseDTO(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getDescription(),
                transaction.getDateTransaction(),
                transaction.getCreateDate()
        );
    }
}
