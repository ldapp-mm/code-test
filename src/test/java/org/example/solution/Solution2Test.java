package org.example.solution;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Solution2Test {
  @ParameterizedTest
  @MethodSource("provideTestNumberAndResult")
  void testFindMaxConsecutiveOnesPositionWithLargeInput(
      int inputNum, int expectedPosition, String message) {
    assertEquals(expectedPosition, Solution2.findMaxConsecutiveOnesPosition(inputNum), message);
  }

  @Test
  void testFindMaxConsecutiveOnesPositionWithNegativeInput() {
    assertThrows(
        IllegalArgumentException.class,
        () -> Solution2.findMaxConsecutiveOnesPosition(-1),
        "Should throw IllegalArgumentException for negative input");
  }

  private static Stream<Arguments> provideTestNumberAndResult() {
    return Stream.of(
        Arguments.of(0, 0, "Position should be 0 for input 0"),
        Arguments.of(1, 1, "Position should be 1 for input 1"),
        Arguments.of(156, 4, "Position should be 4 for input 156"),
        Arguments.of(88, 3, "Position should be 3 for input 88"),
        Arguments.of(Integer.MAX_VALUE, 1, "Position should be 1 for input MAX_VALUE of int 2147483647"));
  }
}
