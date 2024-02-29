//Date: 2/28/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Find Search Insert Position

/*
Given a sorted array of distinct integers and a target value,
return the index if the target is found. If not, return the index where
it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4

Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
*/

public class SearchInsertPosition {

    public static void main(String[] args) {
        int target = 7;
        int[] arr = {1,3,5,6};
        searchInsert(arr, target);
    }
    
    public static int searchInsert(int[] nums, int target) {
        
        //Intialize indexes for binary search
        int left = 0, right = nums.length - 1, mid;

        //Binary Search
        while (left <= right) {            
            mid = left + (right - left) / 2;
            //Check if x is present at mid
            if (nums[mid] == target)
                return mid;
            //If x greater, ignore left half
            if (nums[mid] < target)
                left = mid + 1;
            //If x is smaller, ignore right half
            else
                right = mid - 1;
        }

        //Element not present, return the index where insertion would happen
        return left;
    }
}
