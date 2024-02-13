//Date: 1/22/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Climbing Stairs

/*
Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 
Constraints:
-2^31 <= x <= 2^31 - 1
 
Follow up: Could you solve it without converting the integer to a string?
*/


public class PalindromeNumber {
    
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(121);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(int x) {
        
        //Negative return false
        if (x < 0)
            return false;

        //Numbers less than 10 return true
        if ( x < 10)
            return true;

        //Numbers greater than 10 that end in zero return false
        if (x % 10 == 0)
            return false;

        //Left most place
        int leftMostPlace = 0;
        //Storage for numbres discretely. Max size 2,147,483,647 (10) places
        int[] numbers = new int[10];

        //Stores numbers in array
        while (x > 0) {
            numbers[leftMostPlace] = x % 10;
            ++leftMostPlace;
            x = x/10;
        }

        //Test for palindrome
        for (int i = 0; i < leftMostPlace; ++i) {
            //Test beggining with end, increment down
            if (numbers[i] != numbers[leftMostPlace-i-1])
                return false;
        }

        return true;
    }
}
