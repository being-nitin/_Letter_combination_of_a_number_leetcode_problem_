package com.Recursion;
import java.util.*;
public class Main {

    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/

    public static void main(String[] args) {
	/*
	Given a string containing digits from 2-9 inclusive, return all possible letter
	combinations that the number could represent. Return the answer in any order.
    A mapping of digit to letters (just like on the telephone buttons) is given below.
    Note that 1 does not map to any letters.
    Example 1:
    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    Example 2:
    Input: digits = ""
    Output: []
    Example 3:
    Input: digits = "2"
    Output: ["a","b","c"]
	 */
        letterCombination("", "12");
    }

    public static void letterCombination(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        // in this we have subtracted digit with '0 to make "1" to 1.
        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            letterCombination(p + ch, up.substring(1));
        }
    }
}