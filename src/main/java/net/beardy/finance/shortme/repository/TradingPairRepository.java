package net.beardy.finance.shortme.repository;

import net.beardy.finance.shortme.entity.registry.TradingPair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradingPairRepository extends JpaRepository<TradingPair, Long> {

}
