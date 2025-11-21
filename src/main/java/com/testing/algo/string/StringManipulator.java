package com.testing.algo.string;

import java.util.Arrays;

/**
 * Collection of String manipulation algorithms.
 */
public class StringManipulator {

    /**
     * Reverses a string.
     *
     * @param str The string to reverse.
     * @return The reversed string.
     */
    public String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * Checks if a string is a palindrome.
     *
     * @param str The string to check.
     * @return true if palindrome, false otherwise.
     */
    public boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        String clean = str.replaceAll("\\s+", "").toLowerCase();
        int n = clean.length();
        for (int i = 0; i < n / 2; i++) {
            if (clean.charAt(i) != clean.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if two strings are anagrams.
     *
     * @param str1 First string.
     * @param str2 Second string.
     * @return true if anagrams, false otherwise.
     */
    public boolean isAnagram(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        String s1 = str1.replaceAll("\\s+", "").toLowerCase();
        String s2 = str2.replaceAll("\\s+", "").toLowerCase();

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);
    }

    /**
     * Calculates the Levenshtein distance between two strings.
     * 
     * @param x First string.
     * @param y Second string.
     * @return The Levenshtein distance.
     */
    public int levenshteinDistance(String x, String y) {
        if (x == null || y == null) {
            throw new IllegalArgumentException("Strings cannot be null");
        }

        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1]
                            + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }

        return dp[x.length()][y.length()];
    }

    private int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    private int min(int... numbers) {
        return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    }
}
