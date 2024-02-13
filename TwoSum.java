//Date: 2/1/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Two Sum

/*
Given an array of integers nums and an integer target, return indices of the 
two numbers such that they add up to target.
You may assume that each input would have exactly one solution, 
and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 
Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
*/

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {

        int sum;
        int[] indices = new int[2];
        Map<Integer, Integer> index_num_map = new HashMap<>();

        //Enter nums into map with indices
        for (int i = 0; i < nums.length; ++i) {
            index_num_map.put(nums[i], i);
        }

        //Iterate through to find two indices that have target sum
        for (int i = 0; i < nums.length; ++i) {
            //Calculate needed number
            sum = target - nums[i];
            //Test if map contains needed number and that it is not the same index
            if (index_num_map.containsKey(sum) && i != index_num_map.get(sum)) {
                //Store indices in the array
                indices[0] = i;
                indices[1] = index_num_map.get(sum);
            }
        }
        return indices;
    }
}
