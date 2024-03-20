//Date: 3/20/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Balanced Binary Tree

/*
Given a binary tree, determine if it is height-balanced.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true
 
Constraints:
The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
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

public class BalancedBinaryTree {
    
    public boolean isBalanced(TreeNode root) {
        //If tree is unbalanced function will return negative 1
        return isBalancedRecursive(root) != -1;
    }
    
    private int isBalancedRecursive(TreeNode node) {
        //No more levels return 0
        if (node == null)
            return 0;
        //Find the right and left depths
        int leftDepth = isBalancedRecursive(node.left);
        int rightDepth = isBalancedRecursive(node.right);
        //If any subtree is unbalanced return -1
        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1)
            return -1;
        //Otherwise, return the depth of the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
