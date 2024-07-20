# Coding Test

This document provides instructions on how to use and test `Solution1` and `Solution2` classes.

# Prerequisites

Before you proceed with using and testing `Solution1` and `Solution2`, ensure you have the following installed on your system:

- **Java 11 or above**
- **Maven 3.9.6 or above**

Ensure these prerequisites are met to smoothly run and test `Solution1` and `Solution2`.

# Problems

## Problem 1:

Given a long statement and a input letter, find the word which contains the most number of the given character. If more
than one word has the exact same number of the given letter, it should return the word with the most number of total
letters, if more than one words have equal number of given character and total number of characters return the word that
appeared first in the given statement.

### Examples:

Statement : This is a very long sentence and I want to educate everyone in this whole crazy world….

| Case | Input Character | Expected Result | Explanation                                                                                                                                                                 |
|------|:---------------:|:---------------:|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1    |        z        |      crazy      | z is only present in the word crazy                                                                                                                                         |              
| 2    |        I        |        I        | case sensitive letter I comes only once                                                                                                                                     |
| 3    |        e        |    sentence     | Both sentence and everyone have 3 occurrences of letter e and total length of the words are 8, but sentence occurred first in the input so the expected result is sentence. |

### Assumption for Solution (implemented in Solution1.java)
* `sentence` is not null/empty and assumption that the `sentence` only contains maximum 50,000 words.
* If `sentence` has only 1 word, then assume that the word is not longer than 50.
* `input character` is not empty and assume that it is only alphabetic.

## Problem 2:

Write a function that accept a number and returns the starting position of the longest continuous sequence of 1s in its
binary format.

### Examples:

| Case | Input number | Expected Result | Explanation                                                                                                          |
|------|:------------:|:---------------:|:---------------------------------------------------------------------------------------------------------------------|
| 1    |     156      |        4        | 156 when converted to binary, the result will be 10011100 and the maximum continuous 1s are starting at 4th position |
| 2    |      88      |        3        | 88’s binary representation is 1011000 and the maximum continuous 1s occur at position 3.                             |

### Assumption for Solution (implemented in Solution2.java)
* Assumption that the input number is integer (support till MAX_VALUE of integer) and not negative integer.

# Testing
* go to the project folder
* and run:
``` mvn clean verify```
