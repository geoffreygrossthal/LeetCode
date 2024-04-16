//Date: 4/15/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Majority Element

/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. 
You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 
Constraints:
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 
Follow-up: Could you solve the problem in linear time and in O(1) space?
*/

import java.util.TreeMap;

public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = {2,2,1,3,1,1,4,1,1,5,1,1,6};
        int result = majorityElement(arr);
        System.out.println(result);
    }
    
    //Return the element with the majority element, which is greater or equal to half
    public static int majorityElement(int[] nums) {
        //Calcualte the threshold of half way, rounded down
        int threshold = nums.length / 2;
        //Create map to store number and frequencies
        TreeMap<Integer, Integer> numberFrequencyMap = new TreeMap<>();

        //Iterate through nums
        for (int i = 0; i < nums.length; i++) {
            //Retrieve and incrmenet frequency
            int currentFrequency = numberFrequencyMap.getOrDefault(nums[i], 0) + 1;
            //Majority element will be greater than frequency
            if (currentFrequency > threshold)
                return nums[i];
            //Store freqeuncy in tree
            numberFrequencyMap.put(nums[i], currentFrequency);
        }

        //Return -1 no max freqeucny in array
        return -1;
    }
}
