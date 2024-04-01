//Date: 4/1/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Valid Palindrome

/*
A phrase is a palindrome if, after converting all uppercase letters into 
lowercase letters and removing all non-alphanumeric characters, it reads the 
same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 
Constraints:
1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
*/

public class ValidPalindrome {
    
    //Returns true if string is a palindrome
    public boolean isPalindrome(String s) {

        //Intiliaze indexs
        int left_index = 0, right_index = s.length() - 1;
    
        //Iterate from left and right
        while (left_index < right_index) {
            //Retrieve right and left indexs
            char left_char = s.charAt(left_index);
            char right_char = s.charAt(right_index);
    
            //Skip non-alphanumeric characters
            if (!Character.isLetterOrDigit(left_char)) {
                left_index++;
                continue;
            }
            if (!Character.isLetterOrDigit(right_char)) {
                right_index--;
                continue;
            }
    
            //Convert characters to lowercase for comparison
            left_char = Character.toLowerCase(left_char);
            right_char = Character.toLowerCase(right_char);
    
            //If characters don't match, it's not a palindrome
            if (left_char != right_char)
                return false;
    
            //Left increments, and right decrements
            left_index++;
            right_index--;
        }
        // All corresponding elements matched, return true
        return true;
    }
}
