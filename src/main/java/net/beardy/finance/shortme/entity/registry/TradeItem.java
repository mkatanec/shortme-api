package net.beardy.finance.shortme.entity.registry;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "trade_items")
public class TradeItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trade_item_id_generator")
    @SequenceGenerator(name = "trade_item_id_generator", sequenceName = "trade_item_id_seq", allocationSize = 1)
    private Long id;

    private String name;

}
