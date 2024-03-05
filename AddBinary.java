//Date: 2/29/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Add Binary

/*
Given two binary strings a and b, return their sum as a binary string.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
 
Constraints:
1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
*/

public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("1101", "10"));
    }


    public static String addBinary(String a, String b) {
        //Initialize indices for traversing both strings from the end
        int b_index = b.length() - 1, a_index = a.length() - 1;
        
        //Initialize a boolean variable to track carry
        boolean carry = false;
        
        //Declare variables to store characters from strings a and b
        char a_char, b_char;
        
        //Initialize the result string
        String result = "";
    
        //While both strings have characters left
        while (b_index >= 0 && a_index >= 0) {
            //Get the characters at current indices
            a_char = a.charAt(a_index);
            b_char = b.charAt(b_index);
    
            //Perform binary addition based on characters and carry
            if (a_char == '1' && b_char == '1') {
                if (carry)
                    result = '1' + result;
                else {
                    result = '0' + result;
                    carry = true;
                }
            }
            else if (a_char == '1' || b_char == '1') {
                if (carry) 
                    result = '0' + result;
                else {
                    result = '1' + result;
                }
            }
            else {
                if (carry) {
                    result = '1' + result;
                    carry = false;
                }
                else
                    result = '0' + result;
            }
            
            //Move to the previous characters in both strings
            --a_index;
            --b_index;
        }
    
        //If there are remaining characters in string b
        if (a_index == -1) {
            //Iterate over remaining characters in string b
            for (int i = b_index; i >= 0; --i) {
                //Get the character at current index in string b
                b_char = b.charAt(i);
                //Perform addition with carry
                if (b_char == '1') {
                    if (carry)
                        result = '0' + result;
                    else {
                        return b.substring(0, i + 1) + result;
                    }
                }
                else {
                    if (carry) {
                        result = 1 + result;
                        carry = false;
                    }
                    else 
                        return b.substring(0, i + 1) + result;
                }
            }
        }
        //If there are remaining characters in string a
        else {
            //Iterate over remaining characters in string a
            for (int i = a_index; i >= 0; --i) {
                //Get the character at current index in string a
                a_char = a.charAt(i);
                //Perform addition with carry
                if (a_char == '1') {
                    if (carry)
                        result = '0' + result;
                    else {
                        return a.substring(0, i + 1) + result;
                    }
                }
                else {
                    if (carry) {
                        result = 1 + result;
                        carry = false;
                    }
                    else
                        return a.substring(0, i + 1) + result;
                }
            }
        }
    
        // If there is still a carry, add it to the result
        if (carry)
            result = '1' + result;
    
        return result;
    }
}
