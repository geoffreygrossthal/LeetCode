//Date: 2/7/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Single Number

/*
Given a non-empty array of integers nums, every element appears twice except for one. 
Find that single one.
You must implement a solution with a linear runtime complexity 
and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1
 
Constraints:
1 <= nums.length <= 3 * 10^4
-3 * 10^4 <= nums[i] <= 3 * 10^4
Each element in the array appears twice except for one element which appears only once.
*/

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    
    public static void main(String[] args) {

    }

    public static int singleNumber(int[] nums) {
        
        //Map to denote a number, with boolean to represent single or double appearences
        Map<Integer, Boolean> numbers = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            if (numbers.containsKey(nums[i])) {
                //Denote the value has occurred atleast twice
                numbers.put(nums[i], true);
            }
            else {
                //Denote the vlaue has occurred once
                numbers.put(nums[i], false);
            }
        }

        for (Map.Entry<Integer, Boolean> entry : numbers.entrySet()) {
            int number = entry.getKey();
            boolean occurredOnce = entry.getValue();
            
            //Check if the number occurred only once (value is false)
            if (!occurredOnce) {
                return number;
            }
        }

        return -1;
    }
}
