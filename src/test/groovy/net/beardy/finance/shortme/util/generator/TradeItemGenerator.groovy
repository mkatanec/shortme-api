package net.beardy.finance.shortme.util.generator

import net.beardy.finance.shortme.entity.registry.TradeItem

class TradeItemGenerator extends Generator {

  static Closure FULL = { Long id ->
    [
        id  : id,
        name: "tradeItemName",
    ]
  }

  static TradeItem tradeItem(Long id, overrideProps = [:]) {
    TradeItem entity = map(FULL(id), TradeItem.class)
    map(overrideProps, entity)
    return entity
  }
}
