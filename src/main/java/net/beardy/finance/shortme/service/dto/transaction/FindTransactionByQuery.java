package net.beardy.finance.shortme.service.dto.transaction;

import lombok.Data;
import net.beardy.finance.shortme.entity.TransactionType;
import net.beardy.finance.shortme.entity.registry.TradeItem;

import java.util.List;

@Data
public class FindTransactionByQuery {

    private List<TransactionType> transactionTypes;

    private List<TradeItem> tradeItems;

}
