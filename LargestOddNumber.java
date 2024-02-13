//Date: 12/07/2023
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Largest Odd Number in String

/*
You are given a string num, representing a large integer.
Return the largest-valued odd integer (as a string) that is a non-empty substring of num,
or an empty string "" if no odd integer exists.
A substring is a contiguous sequence of characters within a string.

Examples:

Input: num = "52"
Output: "5"
Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
Example 2:

Input: num = "4206"
Output: ""
Explanation: There are no odd numbers in "4206".
Example 3:

Input: num = "35427"
Output: "35427"
Explanation: "35427" is already an odd number.
*/

public class LargestOddNumber {

    public static void main(String[] args) {
        String test = "52";
        String largestOdd = largestOddNumber(test);
        System.out.println(largestOdd);
        if (largestOdd.equals("")) {
            System.out.println("Default");
        }
    }

    //Returns the largest odd number in the string or "" if none
    public static String largestOddNumber(String num) {

        //Stores a char in the string at a index
        char charAtIndex;
        //Stores the inte reprenation of the char
        int intRepresentation;

        //Iterate from left to right to find the largest odd number
        //First odd number on the left will be the end of the largest odd number
        for (int i = num.length() - 1; i >= 0; --i) {
            //Get char at index i
            charAtIndex = num.charAt(i);
            //Conver the char into an int
            intRepresentation = Character.getNumericValue(charAtIndex);
            //If the char is odd return the largest od number
            if (intRepresentation % 2 == 1) {
                //Return the indexs of the odd number
                return num.substring(0, i+1);
            }
        }
        //Defualt
        return "";
    }
}