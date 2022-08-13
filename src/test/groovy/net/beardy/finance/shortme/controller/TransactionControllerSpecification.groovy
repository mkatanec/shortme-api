package net.beardy.finance.shortme.controller

import net.beardy.finance.shortme.entity.TransactionType
import net.beardy.finance.shortme.repository.TradeItemRepository
import net.beardy.finance.shortme.repository.TransactionRepository
import net.beardy.finance.shortme.test.util.ControllerSpecification
import net.beardy.finance.shortme.test.util.generator.TradeItemGenerator
import net.beardy.finance.shortme.test.util.generator.TransactionGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Subject

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@Subject(TransactionController)
class TransactionControllerSpecification extends ControllerSpecification {

  @Autowired
  private MockMvc mockMvc

  @Autowired
  private TradeItemRepository tradeItemRepository

  @Autowired
  private TransactionRepository transactionRepository

  def "GET /transactions/1 should return transaction"() {
    when:
    def tradeItem = tradeItemRepository.save(TradeItemGenerator.tradeItem(1L))
    transactionRepository.save(TransactionGenerator.transaction(1L, ["tradeItem": tradeItem]))

    def response = mockMvc.perform(get("/transactions/1")).andReturn().response

    then: "response is Ok"
    response.status == HttpStatus.OK.value()

    and: "transactions are fully returned"

    def body = body(response)
    verifyAll(body) {
      id == 1
      transactionType == TransactionType.BUY.toString()
      tradeItemName == "tradeItemName"
      tradeItemPrice == 69.42
      tradeItemAmount == 1
      oneSuggestion:
      [
          price == 34.705,
          amount == 2,
      ]
      twoSuggestion:
      [
          price == 23.13666,
          amount == 3,
      ]
      onePercentSuggestion:
      [
          price == 68.72277,
          amount == 1.01,
      ]
      tenPercentSuggestion:
      [
          price == 63.1,
          amount == 1.1,
      ]
    }
  }

  def "GET /transactions should return transaction"() {
    when:
    def tradeItem = tradeItemRepository.save(TradeItemGenerator.tradeItem(1L))
    transactionRepository.save(TransactionGenerator.transaction(1L, ["tradeItem": tradeItem]))

    def response = mockMvc.perform(
        get("/transactions")
            .queryParam("transactionTypes", TransactionType.BUY.toString()))
        .andReturn().response

    then: "response is Ok"
    response.status == HttpStatus.OK.value()

    and: "transactions are fully returned"

    def body = body(response)
    verifyAll(body) {
      totalItemCount == 1
      currentPage == 0
    }
  }

}
