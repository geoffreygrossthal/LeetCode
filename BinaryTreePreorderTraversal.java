//Date: 4/3/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Add Binary

/*
Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,2,3]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]
 
Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

Follow up: Recursive solution is trivial, could you do it iteratively?
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


public class BinaryTreePreorderTraversal {

   //Method returns an integer list with the vals of the tree in preorder
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderList = new ArrayList<>();
        preorderTraversalRecursive(root, preorderList);
        return preorderList;
    }
    
    //Recursive method to traverse the tree in preorder and add values to the list
    private static void preorderTraversalRecursive(TreeNode node, List<Integer> preorderList) {
        if (node == null)
            return;
        preorderList.add(node.val);
        preorderTraversalRecursive(node.left, preorderList);
        preorderTraversalRecursive(node.right, preorderList);
    }
}