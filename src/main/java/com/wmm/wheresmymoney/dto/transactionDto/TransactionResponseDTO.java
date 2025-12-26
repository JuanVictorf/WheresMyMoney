package com.wmm.wheresmymoney.dto.transactionDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionResponseDTO {
    private int id;
    private BigDecimal amount;
    private String description;
    private String type;
    private String category;
    private LocalDateTime dateTransaction;
    private LocalDateTime createDate;
}
