//Date: 5/22/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Diameter of a Binary Tree

/*
Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in 
a tree. This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.

Example 1:
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:
Input: root = [1,2]
Output: 1
 
Constraints:
The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
*/

public class DiameterOfBinaryTree {

    //Inner class to store the diameter
    class Diameter {
        public int diameter;
    }

    //Method calculates the diameter of a binary tree
    public int diameterOfBinaryTree(TreeNode root) {
        //Create an instance of the Diameter class to store the result
        Diameter result = new Diameter();
        //Initialize the diameter to 0
        result.diameter = 0;
        //Calculate the height of the binary tree and update the diameter
        height(root, result);
        //Diameter is calculated as (number of nodes on the longest path - 1)
        return result.diameter - 1;
    }

    //Recursive method to calculate the height of each node and update the diameter
    private int height(TreeNode root, Diameter result) {
        // Base case: If the current node is null, return 0
        if(root == null)
            return 0;

        //Recursively calculate the height of the left subtree
        int leftHeight = height(root.left, result);
        //Recursively calculate the height of the right subtree
        int rightHeight = height(root.right, result);
        
        //Calculate the diameter passing through the current node
        int dia = leftHeight + rightHeight + 1;
        //Update the diameter if the current diameter is smaller
        result.diameter = Math.max(dia, result.diameter);

        //Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
