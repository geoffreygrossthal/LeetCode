//Date: 4/30/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Sum of Left Leaves

/*
Given the root of a binary tree, return the sum of all left leaves.
A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.

Example 2:
Input: root = [1]
Output: 0
 
Constraints:
The number of nodes in the tree is in the range [1, 1000].
-1000 <= Node.val <= 1000
*/

public class SumOfLeftLeaves {

    //Method returns the sum of all left leaves
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesRec(root, false);
    }

    //Helper function to recurse through trees and return the sum of left leaces
    private int sumOfLeftLeavesRec(TreeNode currentNode, boolean left) {
        //Total of left leafs
        int total = 0;
        if (isLeaf(currentNode)) {
            if (left)
                total += currentNode.val;
        }
        else if (currentNode.right == null)
            total += sumOfLeftLeavesRec(currentNode.left, true);
        else if (currentNode.left == null)
            total += sumOfLeftLeavesRec(currentNode.right, false);
        else
            total = sumOfLeftLeavesRec(currentNode.left, true) + sumOfLeftLeavesRec(currentNode.right, false);
        return total;
    }

    //Method returns true if node is a leaf otherwise false
    private boolean isLeaf(TreeNode node) {
        //Returns true, node does not have children
        if (node.left == null && node.right == null)
            return true;
        //Leaf does have children return false
        else
            return false;
    }
}
