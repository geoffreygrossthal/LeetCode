//Date: 4/4/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Binary Tree Postorder Traversal

/*
Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]

Constraints:
The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 
Follow up: Recursive solution is trivial, could you do it iteratively?
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

public class BinaryTreePostOrderTraversal {

    //Method returns a list with the post order traversal of a binary tree
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorderList = new ArrayList<>();
        postorderTraversal(root, postorderList);
        return postorderList;
    }

    //Recursive method that traverses binary tree postorder and adds values to list
    private static void postorderTraversal(TreeNode node, List<Integer> postOrderList) {
        //Base case null return
        if (node == null)
            return;
        //Furthest right first
        postorderTraversal(node.left, postOrderList);
        //Right next
        postorderTraversal(node.right, postOrderList);
        postOrderList.add(node.val);
    }
}
