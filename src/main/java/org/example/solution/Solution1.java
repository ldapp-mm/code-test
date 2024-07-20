/**
 * Problem 1: Given a long statement and a input letter, find the word which contains the most
 * number of the given character. If more than one word has the exact same number of the given
 * letter, it should return the word with the most number of total letters, if more than one words
 * have equal number of given character and total number of characters return the word that appeared
 * first in the given statement.
 *
 * <p>Examples: Statement : This is a very long sentence and I want to educate everyone in this
 * whole crazy world….
 *
 * <p>Case 1: Input character : z Expected result : crazy Explanation: z is only present in the word
 * crazy
 *
 * <p>Case 2: Input character : I Expected result : I Explanation: case sensitive letter I comes
 * only once
 *
 * <p>Case 3: Input character : e Result : sentence Explanation: Both sentence and everyone have 3
 * occurrences of letter e and total length of the words are 8, but sentence occurred first in the
 * input so the expected result is sentence.
 */
package org.example.solution;

import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution1 {

  private Solution1() {}

  public static String findWordWithMaxNumberOfChars(String sentence, char inputChar) {

    validateSentence(sentence, inputChar);

    String sanitizedSentence = getSanitizedSentence(sentence);

    HashMap<String, Long> words = new HashMap<>();

    Set<String> uniqueWords =
        Arrays.stream(sanitizedSentence.split(" ")).collect(Collectors.toSet());
    uniqueWords.forEach(word -> words.put(word, getWordCount(word, inputChar)));

    return getWordWithMaxCharCount(words);
  }

  private static String getWordWithMaxCharCount(HashMap<String, Long> words) {
    return words.entrySet().stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey)
        .orElse("");
  }

  private static long getWordCount(String word, char character) {
    return word.chars().filter(c -> c == character).count();
  }

  private static String getSanitizedSentence(String sentence) {
    return sentence.replaceAll("[^\\w\\s]", "");
  }

  /**
   * For this function, it is good to use the Validation Constraint to validate the empty, null or
   * size constraint.
   *
   * @param sentence
   * @param inputCharacter
   */
  private static void validateSentence(String sentence, char inputCharacter) {
    if (null == sentence || sentence.isEmpty()) {
      throw new IllegalArgumentException("Sentence cannot be null or empty");
    }

    // "\\s+" regex to split by any whitespace character
    String[] words = sentence.split("\\s+");
    int wordCount = words.length;

    if (wordCount > 50000) {
      throw new IllegalArgumentException("Sentence cannot have more than 50,000 words");
    }
    if (wordCount == 1 && words[0].length() > 50) {
      throw new IllegalArgumentException(
          "Single word in sentence cannot be longer than 50 characters");
    }

    if (inputCharacter == ' ') {
      throw new IllegalArgumentException("Input character cannot be empty");
    }
    if (!Character.isLetter(inputCharacter)) {
      throw new IllegalArgumentException("Input character must be alphabetic");
    }
  }
}
