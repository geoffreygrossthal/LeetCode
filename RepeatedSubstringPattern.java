//Date: 5/23/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Repeated Substring Pattern

/*
Given a string s, check if it can be constructed by taking a substring of it and appending multiple 
copies of the substring together.

Example 1:
Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.

Example 2:
Input: s = "aba"
Output: false

Example 3:
Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 
Constraints:
1 <= s.length <= 104
s consists of lowercase English letters.
*/

public class RepeatedSubstringPattern {

    ///Method returns true if a repeated substring can construct parent string
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String sub = doubled.substring(1, doubled.length() - 1);
        return sub.contains(s);
    }
}