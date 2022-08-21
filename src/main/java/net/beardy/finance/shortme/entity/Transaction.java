package net.beardy.finance.shortme.entity;

import lombok.Data;
import net.beardy.finance.shortme.entity.registry.TradingPair;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id_generator")
    @SequenceGenerator(name = "transaction_id_generator", sequenceName = "transaction_id_seq", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "trading_pair_id")
    private TradingPair tradingPair;

    private BigDecimal tradingPairPrice;

    private BigDecimal tradingPairAmount;

}
