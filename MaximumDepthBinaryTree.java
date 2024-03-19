//Date: 3/19/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Maximum Depth of Binary Tree

/*
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the 
longest path from the root node down to the farthest leaf node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2

Constraints:
The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
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

public class MaximumDepthBinaryTree {

    //Returns the max depth of a tree
    public int maxDepth(TreeNode root) {
        return maxDepthRecursive(root, 0);
    }

    // Recursive function to find the max depth
    private int maxDepthRecursive(TreeNode root, int currentDepth) {
        //End of a path return depth
        if (root == null)
            return currentDepth;
        //FInd left and right depths
        int leftDepth = maxDepthRecursive(root.left, currentDepth + 1);
        int rightDepth = maxDepthRecursive(root.right, currentDepth + 1);
        //Return the max
        return Math.max(leftDepth, rightDepth);
    }
}
