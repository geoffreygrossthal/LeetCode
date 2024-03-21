//Date: 3/21/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Minimum Depth of Binary Tree

/*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down 
to the nearest leaf node.

Note: A leaf is a node with no children.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 2

Example 2:
Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5

Constraints:
The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000
*/

class ListNode {

    int val;
    ListNode next;

    //Default Constructor
    ListNode() {
    }

    //Constructor given int
    ListNode(int val) { 
        this.val = val; 
    }

    //Constructor given int and next node
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}

public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        //End of path return 0
        if (root == null) {
            return 0;
        }
        //No left child go right
        else if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        //No right child go left
        else if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        //Return the min of searches of the leafs
        else
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
