package net.beardy.finance.shortme.mapper;

import lombok.RequiredArgsConstructor;
import net.beardy.finance.shortme.controller.response.ShortSuggestion;
import net.beardy.finance.shortme.controller.response.TransactionDetailsResponse;
import net.beardy.finance.shortme.controller.response.TransactionResponse;
import net.beardy.finance.shortme.entity.Transaction;
import net.beardy.finance.shortme.util.ShortUtil;
import net.beardy.finance.shortme.util.dto.ShortCalculationResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class TransactionDetailsResponseCreateMapper implements CreateMapper<Transaction, TransactionDetailsResponse> {

    private final GenericCreateMapper genericCreateMapper;

    @Override
    public TransactionDetailsResponse map(Transaction from) {
        final TransactionResponse transactionResponse = genericCreateMapper.map(from, TransactionResponse.class);
        final TransactionDetailsResponse transactionDetailsResponse =
            genericCreateMapper.map(transactionResponse, TransactionDetailsResponse.class);

        final ShortCalculationResponse oneShortCalculationResponse =
            ShortUtil.calculateShort(from.getTradingPairPrice(), from.getTradingPairAmount(), BigDecimal.ONE);
        final ShortCalculationResponse twoShortCalculationResponse =
            ShortUtil.calculateShort(from.getTradingPairPrice(), from.getTradingPairAmount(), new BigDecimal(2));
        final ShortCalculationResponse onePercentShortCalculationResponse =
            ShortUtil.calculateShort(from.getTradingPairPrice(), from.getTradingPairAmount(), new BigDecimal("0.01"));
        final ShortCalculationResponse tenPercentShortCalculationResponse =
            ShortUtil.calculateShort(from.getTradingPairPrice(), from.getTradingPairAmount(), new BigDecimal("0.1"));

        transactionDetailsResponse.setOneSuggestion(
            genericCreateMapper.map(oneShortCalculationResponse, ShortSuggestion.class));
        transactionDetailsResponse.setTwoSuggestion(
            genericCreateMapper.map(twoShortCalculationResponse, ShortSuggestion.class));
        transactionDetailsResponse.setOnePercentSuggestion(
            genericCreateMapper.map(onePercentShortCalculationResponse, ShortSuggestion.class));
        transactionDetailsResponse.setTenPercentSuggestion(
            genericCreateMapper.map(tenPercentShortCalculationResponse, ShortSuggestion.class));

        return transactionDetailsResponse;
    }

}
