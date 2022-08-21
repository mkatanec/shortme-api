package net.beardy.finance.shortme.controller


import net.beardy.finance.shortme.test.util.ControllerSpecification
import net.beardy.finance.shortme.test.util.generator.ShortSuggestionRequestGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Subject

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

@Subject(TransactionController)
class CalculatorControllerSpecification extends ControllerSpecification {

  @Autowired
  private MockMvc mockMvc

  def "POST /calculator/suggestions should return automated suggestions"() {
    given:
    def request = ShortSuggestionRequestGenerator.shortSuggestionRequest()

    when:
    def response = mockMvc.perform(
        post("/calculator/suggestions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json(request))
    )
        .andReturn().response

    then: "response is Ok"
    response.status == HttpStatus.OK.value()

    and: "transactions are fully returned"

    def body = body(response)
    verifyAll(body) {
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

}
