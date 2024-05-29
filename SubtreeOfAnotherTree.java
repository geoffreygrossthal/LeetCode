//Date: 5/29/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Subtree of Another Tree

/*
Given the roots of two binary trees root and subRoot, return true if there is a 
subtree of root with the same structure and node values of subRoot and false otherwise.
A subtree of a binary tree tree is a tree that consists of a node in tree and 
all of this node's descendants. The tree tree could also be considered as a 
subtree of itself.

Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
 
Constraints:
The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104
*/

public class SubtreeOfAnotherTree {

    //Method checks is subRoot is a subtree of root
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean subtreeFound = false;
        if (root == null)
            return false;
        else if (root.val == subRoot.val)
            subtreeFound = subTree(root, subRoot);
        
        if (subtreeFound)
            return true;
        else
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    //Method test if subtree is present in tree given equal starting nodes
    private boolean subTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        else if (root == null || subRoot == null)
            return false;
        else
            return (root.val == subRoot.val) && subTree(root.left, subRoot.left) && subTree(root.right, subRoot.right);
    }
}   