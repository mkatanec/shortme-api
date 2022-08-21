package net.beardy.finance.shortme.mapper;

import lombok.RequiredArgsConstructor;
import net.beardy.finance.shortme.entity.Transaction;
import net.beardy.finance.shortme.service.TradingPairService;
import net.beardy.finance.shortme.service.dto.transaction.CreateTransactionCommand;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class TransactionCreateMapper implements CreateMapper<CreateTransactionCommand, Transaction> {

    private final TradingPairService tradingPairService;

    private final GenericCreateMapper genericCreateMapper;

    @Override
    public Transaction map(CreateTransactionCommand from) {
        final Transaction transaction = genericCreateMapper.map(from, Transaction.class);

        if (Objects.nonNull(from.getTradingPairId())) {
            transaction.setTradingPair(tradingPairService.finById(from.getTradingPairId()));
        }

        return transaction;
    }

}
