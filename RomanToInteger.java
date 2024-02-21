//Date: 2/21/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Roman to integer

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, 
just two ones added together. 12 is written as XII, which is simply X + II. 
The number 27 is written as XXVII, which is XX + V + II.
Roman numerals are usually written largest to smallest from left to right. 
However, the numeral for four is not IIII. Instead, the number 
four is written as IV. Because the one is before the five we subtract it making four. 
The same principle applies to the number nine, which is written as IX. 
There are six instances where subtraction is used:
I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Example 1:
Input: s = "III"
Output: 3
Explanation: III = 3.

Example 2:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 3:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 
Constraints:
1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
*/

public class RomanToInteger {
    
    public static void main(String[] args) {
        romanToInt("DCXXI");
    }

    public static int romanToInt(String s) {
        
        int conversion = 0, index = 0;

        //M = 1000
        while (index < s.length() && s.charAt(index) == 'M') {
            conversion += 1000;
            ++index;
        }

        //CM = 900
        if (index < s.length()-1 && s.charAt(index) == 'C' && s.charAt(index+1) == 'M') {
            conversion += 900;
            index += 2;
        }

        //D = 500
        if (index < s.length() && s.charAt(index) == 'D') {
            conversion += 500;
            ++index;
        }

        //CD = 400
        if (index < s.length()-1 && s.charAt(index) == 'C' && s.charAt(index+1) == 'D') {
            conversion += 400;
            index += 2;
        }

        //C = 100
        while (index < s.length() && s.charAt(index) == 'C') {
            conversion += 100;
            ++index;
        }

        //XC = 90
        if (index < s.length()-1 && s.charAt(index) == 'X' && s.charAt(index+1) == 'C') {
            conversion += 90;
            index += 2;
        }

        //L = 50
        if (index < s.length() && s.charAt(index) == 'L') {
            conversion += 50;
            ++index;
        }

        //XL = 40
        if (index < s.length()-1 && s.charAt(index) == 'X' && s.charAt(index+1) == 'L') {
            conversion += 40;
            index += 2;
        }

        //X = 10
        while (index < s.length() && s.charAt(index) == 'X') {
            conversion += 10;
            ++index;
        }

        //IX = 9
        if (index < s.length()-1 && s.charAt(index) == 'I' && s.charAt(index+1) == 'X') {
            conversion += 9;
            index += 2;
        }

        //V = 5
        if (index < s.length() && s.charAt(index) == 'V') {
            conversion += 5;
            ++index;
        }

        //IV = 4
        if (index < s.length()-1 && s.charAt(index) == 'I' && s.charAt(index+1) == 'V') {
            conversion += 4;
            index += 2;
        }

        //I = 1
        while (index < s.length() && s.charAt(index) == 'I') {
            conversion += 1;
            ++index;
        }

        return conversion;
    }
}
