//Date: 3/7/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Merge Sorted Array

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, 
and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead 
be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, 
where the first m elements denote the elements that should be merged, and the last n 
elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. 
The 0 is only there to ensure the merge result can fit in nums1.

Constraints:
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
 
Follow up: Can you come up with an algorithm that runs in O(m + n) time?
*/

import java.util.PriorityQueue;

public class MergeSortedArray {

    public static void main(String[] args) {

        int[] array1 = {1,2,4,5,6,0};
        int num1 = 5;
        int[] array2 = {3};
        int num2 = 1;

        merge(array1, num1, array2, num2);

        for (int i = 0; i < array1.length; ++i) {
            System.out.print(array1[i] + " ");
        }
    }
    
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        //Indexes of nums1 and nums2
        int i = 0;
        //To store elements that need to be isnerted
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        //Continue while either array has elements to merger
        while (i < m + n) {
            //Both arrays have elements to merge
            if (i < m && i < n) {
                //Merge nums1[i], add nums2[i] to the queue
                if (nums1[i] < nums2[i] && (priorityQueue.isEmpty() || nums1[i] <= priorityQueue.peek())) {
                    priorityQueue.add(nums2[i]);
                }
                //Merge nums[2], add nums[i] to queue
                else if (priorityQueue.isEmpty() || nums2[i] <= priorityQueue.peek()) {
                    priorityQueue.add(nums1[i]);
                    nums1[i] = nums2[i];
                }
                //Priorty queue has the lowest, merge it, and insert num1[i]/num2[i] into queue
                else {
                    priorityQueue.add(nums1[i]);
                    nums1[i] = priorityQueue.poll();
                    priorityQueue.add(nums2[i]);
                }
            }
            //nums1 has elements left to merge 
            else if (i < m) {
                //No more elements to merge return
                if (priorityQueue.isEmpty())
                    return;
                //Merge queue
                if (!priorityQueue.isEmpty() && priorityQueue.peek() < nums1[i]) {
                    priorityQueue.add(nums1[i]);
                    nums1[i] = priorityQueue.poll();
                }
            }
            //nums2 has elements left to merge
            else if (i < n) {
                //Merge nums2
                if (priorityQueue.isEmpty() || priorityQueue.peek() > nums2[i]) {
                    nums1[i] = nums2[i];
                }
                //Merge queue
                else {
                    nums1[i] = priorityQueue.poll();
                    priorityQueue.add(nums2[i]);
                }
            }
            //Queue has elements left to merge
            else {
                nums1[i] = priorityQueue.poll();
            }
            ++i;
        }
    }
}
