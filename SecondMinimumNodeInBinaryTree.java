//Date: 5/31/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Second Minimum Node In a Binary Tree

/*
Given a non-empty special binary tree consisting of nodes with the non-negative 
value, where each node in this tree has exactly two or zero sub-node. If the 
node has two sub-nodes, then this node's value is the smaller value among its 
two sub-nodes. More formally, the property root.val = min(root.left.val, 
root.right.val) always holds.
Given such a binary tree, you need to output the second minimum value in the 
set made of all the nodes' value in the whole tree.
If no such second minimum value exists, output -1 instead.

Example 1:
Input: root = [2,2,5,null,null,5,7]
Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.

Example 2:
Input: root = [2,2,2]
Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
 
Constraints:
The number of nodes in the tree is in the range [1, 25].
1 <= Node.val <= 231 - 1
root.val == min(root.left.val, root.right.val) for each internal node of the tre
*/

public class SecondMinimumNodeInBinaryTree {

    //Method returns the second minimum in a non-empty special binary tree or -1
    public int findSecondMinimumValue(TreeNode root) {
        //Single node return -1
        if (root.left == null)
            return -1;
        int larger_value = largerNode(root.left, root.right).val;
        //Create record to store min and second min
        Record mins = new Record();
        mins.min = root.val;
        mins.second_min = larger_value;
        findSecondMinValRec(root, mins);
        //All nodes area min
        if (mins.second_min == mins.min)
            return -1;
        return mins.second_min;
    }

    //Method recurses through tree to find the second minimum
    private void findSecondMinValRec(TreeNode current, Record mins) {
        if (current == null)
            return;
        else if (current.val < mins.min) {
            mins.second_min = mins.min;
            mins.min = current.val;
        }
        else if (current.val < mins.second_min && current.val != mins.min)
            mins.second_min = current.val;

        if (mins.second_min == mins.min)
            mins.second_min = current.val;
        //Search both the right an left side of the trees
        findSecondMinValRec(current.left, mins);
        findSecondMinValRec(current.right, mins);
    }

    //Method returns the node with the larger value
    private TreeNode largerNode(TreeNode node1, TreeNode node2) {
        if (node1.val > node2.val)
            return node1;
        else
            return node2;
    }

    //Record stores min and second min
    class Record {
        int min;
        int second_min;
    }
}