package net.beardy.finance.shortme.util

import spock.lang.Specification
import spock.lang.Subject

@Subject(ShortUtil)
class ShortUtilSpecification extends Specification {

  def "should conclude #result when given #number"() {
    when:
    def response = ShortUtil.hasDecimalPlaces(number)

    then:
    response == result

    where:
    number                     || result
    new BigDecimal("0.00208")  || true
    new BigDecimal("12.08")    || true
    new BigDecimal(24000)      || false
    new BigDecimal("24000.00") || false
  }

  def "should calculate #result when given value: #value and amount: #amount"() {
    when:
    def response = ShortUtil.numberAdder(value, amount)

    then:
    response == result

    where:
    value                      | amount                 || result
    new BigDecimal("0.00208")  | BigDecimal.ONE         || new BigDecimal("0.00209")
    new BigDecimal("12.08")    | BigDecimal.ONE         || new BigDecimal("12.09")
    new BigDecimal(24000)      | BigDecimal.ONE         || new BigDecimal(24001)
    new BigDecimal("24000.00") | BigDecimal.ONE         || new BigDecimal(24001)
    new BigDecimal("0.00208")  | new BigDecimal("0.01") || new BigDecimal("0.0021")
    new BigDecimal("12.08")    | new BigDecimal("0.01") || new BigDecimal("12.2")
    new BigDecimal(24000)      | new BigDecimal("0.01") || new BigDecimal(24240)
    new BigDecimal("24000.00") | new BigDecimal("0.01") || new BigDecimal(24240)
  }

  def "given [sellPrice: #sellPrice, sellAmount: #sellAmount, profit: #profit] should return #result"() {
    given:
    def bigDecimalSellPrice = new BigDecimal(sellPrice)
    def bigDecimalSellAmount = new BigDecimal(sellAmount)
    def bigDecimalProfit = new BigDecimal(profit)

    when:
    def response = ShortUtil.calculateShort(bigDecimalSellPrice, bigDecimalSellAmount, bigDecimalProfit)

    then:
    verifyAll(response) {
      price == result.price
      amount == result.amount
    }

    where:
    sellPrice | sellAmount | profit || result
    "24000"   | "0.00202"  | "1"    || ["price": new BigDecimal("23881.77"), "amount": new BigDecimal("0.00203")]
    "2000"    | "0.015"    | "1"    || ["price": new BigDecimal("1875"), "amount": new BigDecimal("0.016")]
  }

}
