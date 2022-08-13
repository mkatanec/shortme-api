package net.beardy.finance.shortme.controller.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShortSuggestion {

    private BigDecimal price;

    private BigDecimal amount;

}
