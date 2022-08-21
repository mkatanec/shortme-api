package net.beardy.finance.shortme.service;

import net.beardy.finance.shortme.entity.Transaction;
import net.beardy.finance.shortme.service.dto.suggestion.AutomatedSuggestions;
import net.beardy.finance.shortme.service.dto.suggestion.TransactionSuggestion;

import java.math.BigDecimal;

public interface SuggestionService {

    AutomatedSuggestions getSuggestions(BigDecimal sellPrice, BigDecimal sellAmount, BigDecimal fee);

    AutomatedSuggestions getSuggestions(Transaction transaction);

    TransactionSuggestion getSuggestion(BigDecimal sellPrice, BigDecimal sellAmount, BigDecimal fee,
        BigDecimal profit);

    TransactionSuggestion getSuggestion(Transaction transaction, BigDecimal profit);

}
