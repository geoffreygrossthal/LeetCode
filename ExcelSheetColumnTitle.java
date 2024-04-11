//Date: 4/10/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Excel Sheet Column Title

/*
Given an integer columnNumber, return its corresponding 
column title as it appears in an Excel sheet.

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
Input: columnNumber = 1
Output: "A"

Example 2:
Input: columnNumber = 28
Output: "AB"

Example 3:
Input: columnNumber = 701
Output: "ZY"
 
Constraints:
1 <= columnNumber <= 231 - 1
*/

public class ExcelSheetColumnTitle {

    public static void main(String[] args) {
        System.out.println(convertToTitle(28));
    }
    
    public static String convertToTitle(int columnNumber) {
       
        StringBuilder sb = new StringBuilder();
        //Define a string containing all uppercase English letters for the title
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
        //If the column number is less than 27, return the corresponding letter directly
        if(columnNumber < 27)
            return String.valueOf(alphabet.charAt(columnNumber-1));

        //Loop until the column number is greater than 26
        while(columnNumber > 26){
            //Calculate the remainder when columnNumber is divided by 26
            int temp = columnNumber % 26;
            //If the remainder is greater than 0, append the corresponding letter to the StringBuilder
            if (temp > 0) {
                sb.append(alphabet.charAt(temp - 1));
                //Update columnNumber for the next iteration by integer division by 26
                columnNumber /= 26;
            } 
            else {
                //If the remainder is 0, append 'Z' to the StringBuilder
                sb.append('Z');
                //Update columnNumber for the next iteration by integer division by 26
                columnNumber /= 26;
                //Adjust columnNumber by subtracting 1 to handle the carry-over
                columnNumber -= 1;
            }
        }
        //After the loop, append the last letter corresponding to the remaining value of columnNumber
        sb.append(alphabet.charAt(columnNumber - 1));
        
        //Reverse the StringBuilder and convert it to a string before returning
        return String.valueOf(sb.reverse());
    }
}
