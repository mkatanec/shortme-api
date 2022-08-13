package net.beardy.finance.shortme.test.util.generator

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies

abstract class Generator {
  static ModelMapper mapper() {
    ModelMapper mapper = new ModelMapper()
    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD)
    mapper
  }

  static <U, T> T map(U from, Class<T> clazz) {
    mapper().map(from, clazz)
  }

  static <U, T> void map(U from, T to) {
    mapper().map(from, to)
  }
}
