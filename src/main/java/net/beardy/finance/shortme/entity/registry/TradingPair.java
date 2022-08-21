package net.beardy.finance.shortme.entity.registry;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "trading_pairs")
public class TradingPair {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trading_pair_id_generator")
    @SequenceGenerator(name = "trading_pair_id_generator", sequenceName = "trading_pair_id_seq", allocationSize = 1)
    private Long id;

    private String name;

    private BigDecimal fee;

}
