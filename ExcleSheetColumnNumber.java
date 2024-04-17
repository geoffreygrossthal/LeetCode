//Date: 4/17/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Excel Sheet Column Number

/*
Given a string columnTitle that represents the column title as appears in an Excel 
sheet, return its corresponding column number.

For example:
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 
Example 1:
Input: columnTitle = "A"
Output: 1

Example 2:
Input: columnTitle = "AB"
Output: 28

Example 3:
Input: columnTitle = "ZY"
Output: 701
 
Constraints:
1 <= columnTitle.length <= 7
columnTitle consists only of uppercase English letters.
columnTitle is in the range ["A", "FXSHRXW"].
*/

public class ExcleSheetColumnNumber {

    public static void main(String[] args) {
        int result = titleToNumber("AB");
        System.out.println("result: " + result);
    }
    
    public static int titleToNumber(String columnTitle) {
        
        //Create string with alphabet with indexes respresenting corresponding values
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Get value for right index correesponding to 26 power 0
        int result = alphabet.indexOf(columnTitle.charAt(columnTitle.length() - 1)) + 1;
        //Kept track of powers for base 26
        int powerBase26 = 1;

        //Iterate from right to left
        for (int i = columnTitle.length() - 2; i >= 0; --i) {
            //Caculate the power of the char placement
            int powerResultBase26 = (int)Math.pow(26, powerBase26);
            //Times the power by the letter index 
            int newValue = powerResultBase26 * (alphabet.indexOf(columnTitle.charAt(i)) + 1);
            //Add to result
            result += newValue;
            //Move power over with new index
            ++powerBase26;
        }
        
        return result;
    }
}
