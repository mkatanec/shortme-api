package net.beardy.finance.shortme.controller.response;

import lombok.Data;

@Data
public class CalculatorResponse {

    private ShortSuggestion oneSuggestion;

    private ShortSuggestion twoSuggestion;

    private ShortSuggestion onePercentSuggestion;

    private ShortSuggestion tenPercentSuggestion;

}
