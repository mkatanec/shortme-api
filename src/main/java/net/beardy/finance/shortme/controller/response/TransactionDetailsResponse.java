package net.beardy.finance.shortme.controller.response;

import lombok.Data;
import net.beardy.finance.shortme.entity.TransactionType;

import java.math.BigDecimal;

@Data
public class TransactionDetailsResponse {

    private Long id;

    private TransactionType transactionType;

    private String tradeItemName;

    private BigDecimal tradeItemPrice;

    private BigDecimal tradeItemAmount;

    private ShortSuggestion oneSuggestion;

    private ShortSuggestion twoSuggestion;

    private ShortSuggestion onePercentSuggestion;

    private ShortSuggestion tenPercentSuggestion;

}
