package net.beardy.finance.shortme.service.dto.transaction;

import lombok.Data;
import net.beardy.finance.shortme.entity.TransactionType;

import java.util.List;

@Data
public class FindTransactionByQuery {

    private List<TransactionType> transactionTypes;

    private List<Long> tradeItems;

    private int pageIndex = 0;

    private int pageSize = 20;

}
