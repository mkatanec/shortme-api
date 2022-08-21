package net.beardy.finance.shortme.test.util.generator

import net.beardy.finance.shortme.controller.request.ShortSuggestionRequest

class ShortSuggestionRequestGenerator extends Generator {

  static Map FULL =
      [
          price : new BigDecimal("24000"),
          amount: new BigDecimal("0.00202"),
          fee   : new BigDecimal("0"),
      ]

  static ShortSuggestionRequest shortSuggestionRequest(overrideProps = [:]) {
    ShortSuggestionRequest entity = map(FULL, ShortSuggestionRequest.class)
    map(overrideProps, entity)
    return entity
  }
}
