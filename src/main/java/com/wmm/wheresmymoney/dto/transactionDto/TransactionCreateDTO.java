package com.wmm.wheresmymoney.dto.transactionDto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionCreateDTO {
    private int userId;
    private BigDecimal amount;
    private String description;
    private LocalDateTime dateTransaction;
}
