//Date: 3/25/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Path Sum

/*
Given the root of a binary tree and an integer targetSum, 
return true if the tree has a root-to-leaf path such that adding up 
all the values along the path equals targetSum.

A leaf is a node with no children.

Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Example 2:
Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.

Example 3:
Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.

Constraints:
The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
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


public class PathSum { 

    //Method checks if any path to leaf has the target sum
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //Empty tree
        if (root == null)
            return false;
        //Check other paths to leaf
        return recursivePathSum(root, targetSum, 0);
    }

    //Recusrive method to check all paths to leafs
    private boolean recursivePathSum(TreeNode current_node, int target_sum, int current_sum) {
        //Increment current sum with current node value
        current_sum += current_node.val;
        //Check if node is a leaf
        if (current_node.left == null && current_node.right == null) {
            //Equal return true
            if (target_sum == current_sum)
                return true;
            //Not equal return false
            else
                return false;
        }
        //Only right available to traverse
        else if (current_node.left == null)
            return recursivePathSum(current_node.right, target_sum, current_sum);
        //Only left avilable to traverse
        else if (current_node.right == null)
            return recursivePathSum(current_node.left, target_sum, current_sum);
        //Check both right and left if either is true
        return recursivePathSum(current_node.right, target_sum, current_sum) || recursivePathSum(current_node.left, target_sum, current_sum);
    }
}
