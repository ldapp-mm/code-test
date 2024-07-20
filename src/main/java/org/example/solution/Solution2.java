/**
 * Problem 2: Write a function that accept a number and returns the starting position of the longest
 * continuous sequence of 1s in its binary format.
 *
 * <p>Examples: Case 1: Input : 156 Output : 4 Explanation: 156 when converted to binary, the result
 * will be 10011100 and the maximum continuous 1s are starting at 4th position
 *
 * <p>Case 2: Input : 88 Output : 3 Explanation : 88’s binary representation is 1011000 and the
 * maximum continuous 1s occur at position 3.
 */
package org.example.solution;

public class Solution2 {

  private Solution2() {}

  public static int findMaxConsecutiveOnesPosition(int num) {
    validateNumber(num);

    String binary = Integer.toBinaryString(num);

    int currentCount = 0;
    int maxCount = 0;

    int position = 0;
    int tempStartPosition = 0;

    for (int i = 0; i < binary.length(); i++) {
      if (binary.charAt(i) == '1') {
        if (currentCount == 0) {
          tempStartPosition = i;
        }
        currentCount++;
      } else {
        if (currentCount > maxCount) {
          maxCount = currentCount;
          position = tempStartPosition + 1;
        }
        currentCount = 0;
      }
    }

    if (currentCount > maxCount) {
      position = tempStartPosition + 1;
    }

    return position;
  }

  private static void validateNumber(int num) {
    if (num < 0) {
      throw new IllegalArgumentException("Input must be a positive integer.");
    }
  }
}
