package com.wmm.wheresmymoney.mapper.transaction;

import com.wmm.wheresmymoney.dto.transactionDto.TransactionCreateDTO;
import com.wmm.wheresmymoney.dto.transactionDto.TransactionResponseDTO;
import com.wmm.wheresmymoney.dto.transactionDto.TransactionUpdateDTO;
import com.wmm.wheresmymoney.model.Transaction;
import com.wmm.wheresmymoney.model.User;

import java.util.List;

public class TransactionMapper {

    public static Transaction toEntity(TransactionCreateDTO transactionCreateDTO, User user){
        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setAmount(transactionCreateDTO.getAmount());
        transaction.setDescription(transactionCreateDTO.getDescription());
        transaction.setType(transactionCreateDTO.getType());
        transaction.setCategory(transactionCreateDTO.getCategory());
        transaction.setDateTransaction(transactionCreateDTO.getDateTransaction());
        return transaction;
    }

    public static TransactionResponseDTO toResponseDTO(Transaction transaction){
        return new TransactionResponseDTO(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getDescription(),
                transaction.getType(),
                transaction.getCategory(),
                transaction.getDateTransaction(),
                transaction.getCreateDate()
        );
    }

    public static List<TransactionResponseDTO> toResponseDTOList(List<Transaction> transactions){
        return transactions.stream()
                .map(TransactionMapper::toResponseDTO)
                .toList();
    }

    public static TransactionUpdateDTO toUpdateDTO(Transaction transaction){
        return new TransactionUpdateDTO(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getDescription(),
                transaction.getType(),
                transaction.getCategory(),
                transaction.getDateTransaction()
        );
    }
}
