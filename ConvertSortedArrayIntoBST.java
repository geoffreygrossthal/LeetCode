//Date: 2/14/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Convert Sorted Array into Binary Search Tree

/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a 
height-balanced binary search tree.

Example 1:
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:
Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 
Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.
*/


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class ConvertSortedArrayIntoBST {
    
    public static void main(String[] args) {
       
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) 
            return null;
        return intializeTree(nums, 0, nums.length-1);
    }

    public TreeNode intializeTree(int[] nums, int lower, int upper) {
        if (lower > upper) 
            return null;
        //Middle of section to insert to tree
        int mid = lower + (upper - lower) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        //Serach lower bound
        node.left = intializeTree(nums, lower, mid-1);
        //Search upper bound
        node.right = intializeTree(nums, mid+1, upper);
        return node;
    }

}
