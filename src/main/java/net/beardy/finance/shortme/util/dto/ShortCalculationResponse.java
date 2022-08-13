package net.beardy.finance.shortme.util.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ShortCalculationResponse {

    private BigDecimal price;

    private BigDecimal amount;

}
