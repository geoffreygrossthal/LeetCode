//Date: 3/18/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Binary Tree Inorder Traversal

/*
Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]
 
Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/

import java.util.List;
import java.util.ArrayList;

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

class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversalRecursive(root, inorder);
        return inorder;
    }

    private static void inorderTraversalRecursive(TreeNode root, List<Integer> inorder) {
        //No more nodes to left
        if (root == null)
            return;
        //Continue to left
        inorderTraversalRecursive(root.left, inorder);
        //Add to list
        inorder.add(root.val);
        //Add right nodes
        inorderTraversalRecursive(root.right, inorder);
    }
}