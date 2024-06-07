//Date: 6/6/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Contains Duplicates

/*
Given an integer array nums, return true if any value appears at least twice in 
the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 
Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
*/

public class ContainsDuplicates {

    //Method returns true if array contains duplicates otherwise false
    public boolean containsDuplicate(int[] nums) {
        
        //Create a HashMap to store the frequency of each number
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        //Iterate through the array and return true if already inserted
        for (int num : nums) {
            if (frequencyMap.containsKey(num))
                return true;
            frequencyMap.put(num, 1);
        }

        //If no duplicates are found, return false
        return false;
    }
}