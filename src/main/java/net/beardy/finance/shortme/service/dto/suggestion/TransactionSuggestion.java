package net.beardy.finance.shortme.service.dto.suggestion;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionSuggestion {

    private BigDecimal price;

    private BigDecimal amount;

}
