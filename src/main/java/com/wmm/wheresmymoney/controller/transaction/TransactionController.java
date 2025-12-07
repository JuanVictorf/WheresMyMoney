package com.wmm.wheresmymoney.controller.transaction;

import com.wmm.wheresmymoney.dto.transactionDto.TransactionCreateDTO;
import com.wmm.wheresmymoney.dto.transactionDto.TransactionResponseDTO;
import com.wmm.wheresmymoney.mapper.transaction.TransactionMapper;
import com.wmm.wheresmymoney.model.Transaction;
import com.wmm.wheresmymoney.response.ApiResponse;
import com.wmm.wheresmymoney.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TransactionResponseDTO>> createTransaction(@RequestBody TransactionCreateDTO transactionCreateDTO){
        Transaction transaction = transactionService.createTransaction(transactionCreateDTO);
        TransactionResponseDTO transactionResponseDTO = TransactionMapper.toResponseDTO(transaction);

        ApiResponse<TransactionResponseDTO> response = new ApiResponse<>("Transação criada com sucesso", transactionResponseDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }
}
