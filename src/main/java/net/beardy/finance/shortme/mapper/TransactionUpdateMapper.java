package net.beardy.finance.shortme.mapper;

import lombok.RequiredArgsConstructor;
import net.beardy.finance.shortme.entity.Transaction;
import net.beardy.finance.shortme.service.TradingPairService;
import net.beardy.finance.shortme.service.dto.transaction.UpdateTransactionCommand;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class TransactionUpdateMapper implements UpdateMapper<UpdateTransactionCommand, Transaction> {

    private final TradingPairService tradingPairService;

    private final GenericUpdateMapper genericUpdateMapper;

    @Override
    public void map(UpdateTransactionCommand from, Transaction to) {
        genericUpdateMapper.map(from, to);

        if (Objects.nonNull(from.getTradingPairId())) {
            to.setTradingPair(tradingPairService.finById(from.getTradingPairId()));
        }
    }

}
