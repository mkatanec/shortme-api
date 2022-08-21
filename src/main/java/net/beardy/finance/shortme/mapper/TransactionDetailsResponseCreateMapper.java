package net.beardy.finance.shortme.mapper;

import lombok.RequiredArgsConstructor;
import net.beardy.finance.shortme.controller.response.ShortSuggestion;
import net.beardy.finance.shortme.controller.response.TransactionDetailsResponse;
import net.beardy.finance.shortme.controller.response.TransactionResponse;
import net.beardy.finance.shortme.entity.Transaction;
import net.beardy.finance.shortme.service.dto.suggestion.AutomatedSuggestions;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionDetailsResponseCreateMapper
    implements CreateMapper<Pair<Transaction, AutomatedSuggestions>, TransactionDetailsResponse> {

    private final GenericCreateMapper genericCreateMapper;

    @Override
    public TransactionDetailsResponse map(Pair<Transaction, AutomatedSuggestions> from) {
        final Transaction transaction = from.getFirst();
        final AutomatedSuggestions suggestions = from.getSecond();

        final TransactionResponse transactionResponse = genericCreateMapper.map(transaction, TransactionResponse.class);
        final TransactionDetailsResponse transactionDetailsResponse =
            genericCreateMapper.map(transactionResponse, TransactionDetailsResponse.class);

        transactionDetailsResponse.setOneSuggestion(
            genericCreateMapper.map(suggestions.getOneSuggestion(), ShortSuggestion.class));
        transactionDetailsResponse.setTwoSuggestion(
            genericCreateMapper.map(suggestions.getTwoSuggestion(), ShortSuggestion.class));
        transactionDetailsResponse.setOnePercentSuggestion(
            genericCreateMapper.map(suggestions.getOnePercentSuggestion(), ShortSuggestion.class));
        transactionDetailsResponse.setTenPercentSuggestion(
            genericCreateMapper.map(suggestions.getTenPercentSuggestion(), ShortSuggestion.class));

        return transactionDetailsResponse;
    }

}
