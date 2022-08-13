package net.beardy.finance.shortme.test.util.generator

import net.beardy.finance.shortme.entity.Transaction
import net.beardy.finance.shortme.entity.TransactionType

class TransactionGenerator extends Generator {

  static Closure FULL = { Long id ->
    [
        id             : id,
        transactionType: TransactionType.BUY,
        tradeItemPrice : 69.42,
        tradeItemAmount: 69.42,
    ]
  }

  static Transaction transaction(Long id, overrideProps = [:]) {
    Transaction entity = mapper().map(FULL(id), Transaction.class)
    mapper().map(overrideProps, entity)
    return entity
  }
}
