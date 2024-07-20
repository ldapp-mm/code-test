package org.example.solution;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.solution.TestVectors.TEST_CASE_SENTENCE;
import static org.example.solution.TestVectors.TEST_SENTENCE;
import static org.example.solution.TestVectors.TEST_SENTENCE_WITH_SPECIAL_CHARS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Solution1Test {

  @Test
  void testConstructorWithEmptySentence() {
    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class, () -> Solution1.findWordWithMaxNumberOfChars("", 'e'));
    assertEquals("Sentence cannot be null or empty", thrown.getMessage());
  }

  @Test
  void testConstructorWithNullSentence() {
    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> Solution1.findWordWithMaxNumberOfChars(null, 'e'));
    assertEquals("Sentence cannot be null or empty", thrown.getMessage());
  }

  @Test
  void testConstructorWithEmptyChar() {
    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> Solution1.findWordWithMaxNumberOfChars("test sentence", ' '));
    assertEquals("Input character cannot be empty", thrown.getMessage());
  }

  @Test
  void testSingleWordWithMoreThan50Characters() {
    String sentence = "a".repeat(51);
    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> Solution1.findWordWithMaxNumberOfChars(sentence, 'a'));
    assertEquals(
        "Single word in sentence cannot be longer than 50 characters", thrown.getMessage());
  }

  @Test
  void testSentenceMaxLength() {
    // Generate a string longer than 50,000 words
    String longSentence = TEST_SENTENCE.repeat(50).concat(" ");
    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> Solution1.findWordWithMaxNumberOfChars(longSentence, 'a'));
    assertTrue(
        thrown.getMessage().contains("Sentence cannot have more than 50,000 words"));
  }

  @ParameterizedTest
  @MethodSource("provideTestSentenceInputCharacterAndResult")
  void testFindWordWithMaxNumberOfChars(String sentence, char inputChar, String expected) {
    assertEquals(expected, Solution1.findWordWithMaxNumberOfChars(sentence, inputChar));
  }

  private static Stream<Arguments> provideTestSentenceInputCharacterAndResult() {
    return Stream.of(
        Arguments.of(TEST_CASE_SENTENCE, 'z', "crazy"),
        Arguments.of(TEST_CASE_SENTENCE, 'I', "I"),
        Arguments.of(TEST_CASE_SENTENCE, 'e', "sentence"),
        Arguments.of(TEST_SENTENCE_WITH_SPECIAL_CHARS, 'l', "hello"),
        Arguments.of(TEST_SENTENCE.repeat(45).concat(" "), 'k', "Bartkowiak"),
        Arguments.of(TEST_SENTENCE.repeat(45).concat(" "), 'K', "Konkonkon"));
  }
}
