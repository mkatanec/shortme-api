insert into short_me.transactions (transaction_type, trade_item_id, trade_item_price, trade_item_amount)
values ('BUY', (select ti.id from short_me.trade_items ti where ti.name = 'tradeItem1'), 69.42, 1),
       ('BUY', (select ti.id from short_me.trade_items ti where ti.name = 'tradeItem2'), 42.69, 1),
       ('BUY', (select ti.id from short_me.trade_items ti where ti.name = 'tradeItem3'), 33.314, 1);