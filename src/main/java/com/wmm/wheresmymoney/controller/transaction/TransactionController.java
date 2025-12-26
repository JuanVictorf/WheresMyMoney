package com.wmm.wheresmymoney.controller.transaction;

import com.wmm.wheresmymoney.dto.transactionDto.TransactionCreateDTO;
import com.wmm.wheresmymoney.dto.transactionDto.TransactionResponseDTO;
import com.wmm.wheresmymoney.dto.transactionDto.TransactionUpdateDTO;
import com.wmm.wheresmymoney.mapper.transaction.TransactionMapper;
import com.wmm.wheresmymoney.model.Transaction;
import com.wmm.wheresmymoney.response.ApiResponse;
import com.wmm.wheresmymoney.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TransactionResponseDTO>> create(@RequestBody TransactionCreateDTO transactionCreateDTO){
        Transaction transaction = transactionService.createTransaction(transactionCreateDTO);
        TransactionResponseDTO transactionResponseDTO = TransactionMapper.toResponseDTO(transaction);

        ApiResponse<TransactionResponseDTO> response = new ApiResponse<>("Transação criada com sucesso", transactionResponseDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable int id){
        transactionService.deleteTransaction(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>("Transação deletada com sucesso", null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TransactionResponseDTO>>> getTransactions(@RequestParam int userId){
        List<Transaction> transactions = transactionService.findAllTransactionByUserId(userId);
        List<TransactionResponseDTO> transactionResponseDTO = TransactionMapper.toResponseDTOList(transactions);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>("Transações", transactionResponseDTO));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<TransactionUpdateDTO>> update(@RequestBody TransactionUpdateDTO transactionUpdateDTO){
        Transaction transaction = transactionService.updateTransaction(transactionUpdateDTO);
        TransactionUpdateDTO transactionUpdateDTO1 = TransactionMapper.toUpdateDTO(transaction);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>("Transação atualizada com sucesso", transactionUpdateDTO1));
    }
}
