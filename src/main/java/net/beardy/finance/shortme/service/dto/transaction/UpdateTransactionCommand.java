package net.beardy.finance.shortme.service.dto.transaction;

import lombok.Data;
import net.beardy.finance.shortme.entity.TransactionType;

import java.math.BigDecimal;

@Data
public class UpdateTransactionCommand {

    private Long id;

    private TransactionType transactionType;

    private Long tradeItemId;

    private BigDecimal tradeItemPrice;

    private BigDecimal tradeItemAmount;

}
