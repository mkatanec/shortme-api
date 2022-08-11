package net.beardy.finance.shortme.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "shorts")
public class Short {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "short_id_generator")
    @SequenceGenerator(name = "short_id_generator", sequenceName = "short_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sell_transaction_id")
    private Transaction sellTransaction;

    @ManyToOne
    @JoinColumn(name = "buy_transaction_id")
    private Transaction buyTransaction;

}
