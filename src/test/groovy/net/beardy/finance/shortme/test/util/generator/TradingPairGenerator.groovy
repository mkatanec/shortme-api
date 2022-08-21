package net.beardy.finance.shortme.test.util.generator


import net.beardy.finance.shortme.entity.registry.TradingPair

class TradingPairGenerator extends Generator {

  static Closure FULL = { Long id ->
    [
        id  : id,
        name: "BTC/BUSD",
        fee : 0,
    ]
  }

  static TradingPair tradingPair(Long id, overrideProps = [:]) {
    TradingPair entity = map(FULL(id), TradingPair.class)
    map(overrideProps, entity)
    return entity
  }
}
