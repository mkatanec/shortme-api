insert into short_me.transactions (transaction_type, trading_pair_id, trading_pair_price, trading_pair_amount)
values ('BUY', (select ti.id from short_me.trading_pairs ti where ti.name = 'BTC/BUSD'), 21420, 0.00233),
       ('BUY', (select ti.id from short_me.trading_pairs ti where ti.name = 'ETH/BUSD'), 21500, 0.00093),
       ('BUY', (select ti.id from short_me.trading_pairs ti where ti.name = 'SOL/BUSD'), 69.42, 1),
       ('BUY', (select ti.id from short_me.trading_pairs ti where ti.name = 'BTC/BUSD'), 42.69, 1),
       ('BUY', (select ti.id from short_me.trading_pairs ti where ti.name = 'ETH/BUSD'), 33.314, 1),
       ('SELL', (select ti.id from short_me.trading_pairs ti where ti.name = 'SOL/BUSD'), 69.42, 1),
       ('SELL', (select ti.id from short_me.trading_pairs ti where ti.name = 'BTC/BUSD'), 42.69, 1),
       ('SELL', (select ti.id from short_me.trading_pairs ti where ti.name = 'ETH/BUSD'), 33.314, 1),
       ('SELL', (select ti.id from short_me.trading_pairs ti where ti.name = 'SOL/BUSD'), 33.314, 1.32);
