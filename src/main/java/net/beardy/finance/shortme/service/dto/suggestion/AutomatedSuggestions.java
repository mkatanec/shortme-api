package net.beardy.finance.shortme.service.dto.suggestion;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AutomatedSuggestions {

    private TransactionSuggestion oneSuggestion;

    private TransactionSuggestion twoSuggestion;

    private TransactionSuggestion onePercentSuggestion;

    private TransactionSuggestion tenPercentSuggestion;

}
