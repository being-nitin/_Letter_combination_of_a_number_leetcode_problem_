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
        // printing all the corresponding answers.
        letterCombination("", "12");
        ArrayList<String> list = letterCombinationArray("", "12");
        System.out.println(list);
        //count the number of elements.
        System.out.println(letterCombinationCount("","12"));

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

    // Return the ans in Arraylist.
    public static ArrayList<String> letterCombinationArray(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        // in this we have subtracted digit with '0 to make "1" to 1.
        int digit = up.charAt(0) - '0';
        ArrayList<String> ans = new ArrayList<>();
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            ans.addAll(letterCombinationArray(p + ch, up.substring(1)));
        }
        return ans;
    }

    public static int letterCombinationCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }// in this we have subtracted digit with '0 to make "1" to 1.
        int digit = up.charAt(0) - '0';
        int count = 0;
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            count = count + letterCombinationCount(p + ch, up.substring(1));
        }
        return count;
    }
}