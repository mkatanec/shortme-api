package net.beardy.finance.shortme.controller.response;

import lombok.Data;
import net.beardy.finance.shortme.entity.TransactionType;

import java.math.BigDecimal;

@Data
public class TransactionResponse {

    private Long id;

    private TransactionType transactionType;

    private String tradingPairName;

    private BigDecimal tradingPairPrice;

    private BigDecimal tradingPairAmount;

}
