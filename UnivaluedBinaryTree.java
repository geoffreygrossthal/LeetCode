//Date: 6/1/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Univalued Binary Tree

/*
A binary tree is uni-valued if every node in the tree has the same value.
Given the root of a binary tree, return true if the given tree is uni-valued, 
or false otherwise.

Example 1:
Input: root = [1,1,1,1,1,null,1]
Output: true

Example 2:
Input: root = [2,2,2,5,2]
Output: false
 
Constraints:
The number of nodes in the tree is in the range [1, 100].
0 <= Node.val < 100
*/

public class UnivaluedBinaryTree {

    //Method returns true if binary tree is univalued, otherwise false
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTreeRec(root, root.val);
    }

    //Method recurses through tree and returns true if univalued, otherwise false
    private boolean isUnivalTreeRec(TreeNode node, int val) {
        if (node == null)
            return true;
        else if (node.val != val)
            return false;
        else
            return isUnivalTreeRec(node.left, val) && isUnivalTreeRec(node.right, val);
    }
}