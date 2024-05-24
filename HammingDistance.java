//Date: 5/24/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Hamming Distance

/*
The Hamming distance between two integers is the number of positions at which the corresponding 
bits are different.
Given two integers x and y, return the Hamming distance between them.

Example 1:
Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.

Example 2:
Input: x = 3, y = 1
Output: 1
 
Constraints:
0 <= x, y <= 231 - 1
*/

public class HammingDistance {

    //Method calculates the hamming distance between two decimal integers
    public int hammingDistance(int x, int y) {
        
        int distance = 0, remainder_x, remainder_y, larger = Math.max(x, y);
        int binary_length = (Math.log(larger) / Math.log(2)) + 1;

        for (int i = 0; i < binary_length; ++i) {
            remainder_x = x % 2;
            remainder_y = y % 2;
            if (remainder_x != remainder_y)
                ++distance;
            x /= 2;
            y /= 2;
        }
        
        return distance;
    }
}