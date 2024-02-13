//Date: 2/2/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Length of Last Word

/*
Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.

Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
 
Constraints:
1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.
*/

public class LengthOfLastWord {
    
    public static void main(String[] args) {

        System.out.println(lengthOfLastWord("hello to"));
    }

    public static int lengthOfLastWord(String s) {
    
        int previous_word = 0;
        int current_word = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                current_word = 0;
            }
            else {
                ++current_word;
                previous_word = current_word;
            }
        }

        return previous_word;
    }
}
