//Date: 6/1/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Score of a String

/*
Input: s = "hello"
Output: 13

Explanation:
The ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108, 
'o' = 111. So, the score of s would be |104 - 101| + |101 - 108| + |108 - 108| 
+ |108 - 111| = 3 + 7 + 0 + 3 = 13.

Example 2:
Input: s = "zaz"
Output: 50

Explanation:
The ASCII values of the characters in s are: 'z' = 122, 'a' = 97. 
So, the score of s would be |122 - 97| + |97 - 122| = 25 + 25 = 50.

Constraints:
2 <= s.length <= 100
s consists only of lowercase English letters.
*/

public class ScoreOfAString {

    //Method returns the absolute difference of the adjacent characters
    //ASCII values in a string
    public int scoreOfString(String s) {
        int score = 0;
        char ch1, ch2;
        for (int i = 0; i < s.length()-1; i++) {
            ch1 = s.charAt(i);
            ch2 = s.charAt(i+1);
            score += Math.abs((int)ch1 - (int)ch2);
        }
        return score;
    }
}