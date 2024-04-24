//Date: 4/24/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Invert Binary Tree

/*
Given the root of a binary tree, invert the tree, and return its root.

Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:
Input: root = [2,1,3]
Output: [2,3,1]

Example 3:
Input: root = []
Output: []
 
Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/


public class InvertBinaryTree {

    //Method will invert a binary tree given the root
    public TreeNode invertTree(TreeNode root) {
        return recursiveInvertTree(root);
    }

    //Private helper method to recursive invert a binary tree
    private static TreeNode recursiveInvertTree(TreeNode currentNode) {
        if (currentNode == null)
            return currentNode;
        TreeNode temp = recursiveInvertTree(currentNode.left);
        currentNode.left = recursiveInvertTree(currentNode.right);
        currentNode.right = temp;
        return currentNode;
    }
}
