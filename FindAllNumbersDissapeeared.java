//Date: 2/8/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Find all Numbers Dissapeared

/*
Given an array nums of n integers where nums[i] is in the range [1, n],
return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:
Input: nums = [1,1]
Output: [2]
 
Constraints:
n == nums.length
1 <= n <= 105
1 <= nums[i] <= n

Follow up: Could you do it without extra space and in O(n) runtime? 
You may assume the returned list does not count as extra space.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllNumbersDissapeeared {
    
    public static void main(String[] args) {

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> dissapeared_numbers = new ArrayList<>();
        Map<Integer, Boolean> inserted_Numbers = new HashMap<>();

        //Insert the possible numbers into the list
        for (int i = 0; i < nums.length; ++i) {
            if (inserted_Numbers.containsKey(nums[i])) {
                continue;
            } else {
                inserted_Numbers.put(nums[i], true);
            }
        }

        //Remove numbers that are present
        for (int i = 1; i <= nums.length; ++i) {
            if (!inserted_Numbers.containsKey(i)) {
                dissapeared_numbers.add(i);
            }
        }

        return dissapeared_numbers;
    }
}
