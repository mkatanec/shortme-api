package net.beardy.finance.shortme.service.impl;

import lombok.RequiredArgsConstructor;
import net.beardy.finance.shortme.entity.Transaction;
import net.beardy.finance.shortme.mapper.GenericCreateMapper;
import net.beardy.finance.shortme.service.SuggestionService;
import net.beardy.finance.shortme.service.dto.suggestion.AutomatedSuggestions;
import net.beardy.finance.shortme.service.dto.suggestion.TransactionSuggestion;
import net.beardy.finance.shortme.util.ShortUtil;
import net.beardy.finance.shortme.util.dto.ShortCalculationResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {

    private final GenericCreateMapper genericCreateMapper;

    @Override
    public AutomatedSuggestions getSuggestions(BigDecimal sellPrice, BigDecimal sellAmount, BigDecimal fee) {
        return AutomatedSuggestions.builder()
            .oneSuggestion(getSuggestion(sellPrice, sellAmount, fee, BigDecimal.ONE))
            .twoSuggestion(getSuggestion(sellPrice, sellAmount, fee, new BigDecimal(2)))
            .onePercentSuggestion(getSuggestion(sellPrice, sellAmount, fee, new BigDecimal("0.01")))
            .tenPercentSuggestion(getSuggestion(sellPrice, sellAmount, fee, new BigDecimal("0.1")))
            .build();
    }

    @Override
    public AutomatedSuggestions getSuggestions(Transaction transaction) {
        final BigDecimal fee = transaction.getTradingPair().getFee();
        return getSuggestions(transaction.getTradingPairPrice(), transaction.getTradingPairAmount(), fee);
    }

    @Override
    public TransactionSuggestion getSuggestion(BigDecimal sellPrice, BigDecimal sellAmount, BigDecimal fee,
        BigDecimal profit) {
        final ShortCalculationResponse shortCalculation = ShortUtil.calculateShort(sellPrice, sellAmount, profit, fee);
        return genericCreateMapper.map(shortCalculation, TransactionSuggestion.class);
    }

    @Override
    public TransactionSuggestion getSuggestion(Transaction transaction, BigDecimal profit) {
        final BigDecimal fee = transaction.getTradingPair().getFee();
        return getSuggestion(transaction.getTradingPairPrice(), transaction.getTradingPairAmount(), fee, profit);
    }

}
