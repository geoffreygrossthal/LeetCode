//Date: 7/13/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Special Array

/*
An array is considered special if every pair of its adjacent elements contains two numbers with 
different parity. You are given an array of integers nums. Return true if nums is a special array, 
otherwise, return false.

Example 1:
Input: nums = [1]
Output: true
Explanation:
There is only one element. So the answer is true.

Example 2:
Input: nums = [2,1,4]
Output: true
Explanation:
There is only two pairs: (2,1) and (1,4), and both of them contain numbers with different parity. So the answer is true.

Example 3:
Input: nums = [4,3,1,6]
Output: false
Explanation:
nums[1] and nums[2] are both odd. So the answer is false.

Constraints:
1 <= nums.length <= 100
1 <= nums[i] <= 100
*/

public class SpecialArray {

    //Method retursn true if array is special, no adjacent pair with both odd or even
    public bool IsArraySpecial(int[] nums) {
        bool odd = (nums[0] % 2 == 1);
        for (int i = 1; i < nums.Length; ++i) {
            //Even
            if (nums[i] % 2 == 0) {
                //Two evens in a row
                if (!odd)
                    return false;
                odd = false;
            }
            //Odd
            else {
                if (odd)
                    return false;
                odd = true;
            }
        }
        return true;
    }
}