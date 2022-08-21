package net.beardy.finance.shortme.service.impl;

import lombok.RequiredArgsConstructor;
import net.beardy.finance.shortme.entity.registry.TradingPair;
import net.beardy.finance.shortme.exception.EntityNotFoundException;
import net.beardy.finance.shortme.repository.TradingPairRepository;
import net.beardy.finance.shortme.service.TradingPairService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TradingPairServiceImpl implements TradingPairService {

    private final TradingPairRepository tradingPairRepository;

    @Override
    public TradingPair finById(Long id) {
        return tradingPairRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(TradingPair.class, String.format("id=%d", id)));
    }

}
