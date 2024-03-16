//Date: 3/16/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Symmetric Tree

/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false
 
Constraints:
The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 
Follow up: Could you solve it both recursively and iteratively?
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

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        //Return the results of left tree and right tree matching
        return matchLeftRight(root.left, root.right);
    }

    public static boolean matchLeftRight(TreeNode leftTree, TreeNode rightTree) {
        
        //Both are null return true
        if (leftTree == null && rightTree == null)
            return true;

        //If only one is null return false
        else if (leftTree == null || rightTree == null)
            return false;

        //If they do not equal return false
        else if (leftTree.val != rightTree.val)
            return false;

        //Recusive search both the left and right symmetric pairs
        return (matchLeftRight(leftTree.left, rightTree.right) && matchLeftRight(leftTree.right, rightTree.left));
    }
}
