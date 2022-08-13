package net.beardy.finance.shortme.test.util

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.mock.web.MockHttpServletResponse
import org.springframework.test.annotation.DirtiesContext
import spock.lang.Specification

import javax.transaction.Transactional

@AutoConfigureMockMvc(printOnlyOnFailure = false)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
@Transactional
abstract class ControllerSpecification extends Specification {

  @Autowired
  ObjectMapper objectMapper

  def <T> T body(MockHttpServletResponse response, Class<T> cls = Map.class) {
    objectMapper.readValue(response.contentAsString, cls)
  }

}
