//Date: 2/13/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Count Elements with Maximum Frequency

/*
You are given an array nums consisting of positive integers.
Return the total frequencies of elements in nums such that 
those elements all have the maximum frequency.
The frequency of an element is the number of occurrences of that element in the array.

Example 1:
Input: nums = [1,2,2,3,1,4]
Output: 4
Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
So the number of elements in the array with maximum frequency is 4.

Example 2:
Input: nums = [1,2,3,4,5]
Output: 5
Explanation: All elements of the array have a frequency of 1 which is the maximum.
So the number of elements in the array with maximum frequency is 5.
 
Constraints:
1 <= nums.length <= 100
1 <= nums[i] <= 100
*/

public class CountElementsWithMaxFrequency {

    public static void Main(String[] args) {

    }

    public static int maxFrequencyElements(int[] nums) {
    
        int max_frequency = 0;
        int max_total = 0;
        int[] occured_nums = new int[101];

        //Iterate through nums, increment index of occurence to find frequency
        for (int i = 0; i < nums.length; ++i)
            ++occured_nums[nums[i]];

        //Sum total of max frequencies
        for (int i = 0; i < occured_nums.length; ++i) {
            //Greater max frequency found, restart sum with new frequency
            if (max_frequency < occured_nums[i]) {
                max_frequency = occured_nums[i];
                max_total = occured_nums[i];
            }
            //Another instance of max frequency found, add it to the total
            else if (occured_nums[i] == max_frequency) {
                max_total += max_frequency;
            }
        }

        return max_total;
    }
}
