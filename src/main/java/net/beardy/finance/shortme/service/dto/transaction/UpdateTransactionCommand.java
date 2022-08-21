package net.beardy.finance.shortme.service.dto.transaction;

import lombok.Data;
import net.beardy.finance.shortme.entity.TransactionType;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class UpdateTransactionCommand {

    @NotNull
    private Long id;

    @NotNull
    private TransactionType transactionType;

    @NotNull
    private Long tradingPairId;

    @NotNull
    private BigDecimal tradingPairPrice;

    @NotNull
    private BigDecimal tradingPairAmount;

}
