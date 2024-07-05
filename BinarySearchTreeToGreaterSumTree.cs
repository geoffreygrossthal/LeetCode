//Date: 7/5/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Convert Binary Search Tree to Greater Sum Tree

/*
Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original 
key plus the sum of all keys greater than the original key in BST.
As a reminder, a binary search tree is a tree that satisfies these constraints:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 
Example 1:
Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

Example 2:
Input: root = [0,null,1]
Output: [1,null,1]
 
Constraints:
The number of nodes in the tree is in the range [1, 100].
0 <= Node.val <= 100
All the values in the tree are unique.
 
Note: This question is the same as 538: https://leetcode.com/problems/convert-bst-to-greater-tree/
*/


public class Solution {

    //Method converts a binary search tree to a Greater Sum Tree
    public TreeNode BstToGst(TreeNode root) {
        Sum sum_record = new Sum();
        sum_record.sum = 0;
        BstToGstRec(root, sum_record);
        return root;
    }

    //Method recursively converts a binary search tree to a Greater Sum Tree
    public void BstToGstRec(TreeNode node, Sum sum_record) {
        if (node == null)
            return;
        BstToGstRec(node.right, sum_record);
        sum_record.sum += node.val;
        node.val = sum_record.sum;
        BstToGstRec(node.left, sum_record);
    } 

    //Record stores a sum integer
    public class Sum {
        public int sum;
    }
}