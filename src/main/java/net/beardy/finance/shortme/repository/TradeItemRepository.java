package net.beardy.finance.shortme.repository;

import net.beardy.finance.shortme.entity.registry.TradeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeItemRepository extends JpaRepository<TradeItem, Long> {

}
