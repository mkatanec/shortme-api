package net.beardy.finance.shortme.service.impl;

import lombok.RequiredArgsConstructor;
import net.beardy.finance.shortme.entity.registry.TradeItem;
import net.beardy.finance.shortme.exception.EntityNotFoundException;
import net.beardy.finance.shortme.repository.TradeItemRepository;
import net.beardy.finance.shortme.service.TradeItemService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TradeItemServiceImpl implements TradeItemService {

    private final TradeItemRepository tradeItemRepository;

    @Override
    public TradeItem finById(Long id) {
        return tradeItemRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(TradeItem.class, String.format("id=%d", id)));
    }

}
