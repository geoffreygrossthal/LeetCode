//Date: 6/12/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Sort Colors

/*
Given an array nums with n objects colored red, white, or blue, sort them 
in-place so that objects of the same color are adjacent, with the colors in 
the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and 
blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]
 
Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 

Follow up: Could you come up with a one-pass algorithm using only constant 
extra space?
*/

public class SortColors {

    //Method sorts the colors red (0) / white (1) / blue (2)
    public int[] sortColors(int[] nums) {
        //Insertion sort, small number of elements (nums.length < 300) and constant space
        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            int key = nums[i];
            int j = i - 1; 
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }
    }
}