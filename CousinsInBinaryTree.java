//Date: 6/1/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Cousins In Binary Tree

/*
Given the root of a binary tree with unique values and the values of two 
different nodes of the tree x and y, return true if the nodes corresponding to 
the values x and y in the tree are cousins, or false otherwise.
Two nodes of a binary tree are cousins if they have the same depth with 
different parents. Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 
Constraints:
The number of nodes in the tree is in the range [2, 100].
1 <= Node.val <= 100
Each node has a unique value.
x != y
x and y are exist in the tree.
*/

public class CousinsInBinaryTree {

    //Method returns true if two corresponding nodes are cousins, otherwise false
    public boolean isCousins(TreeNode root, int x, int y) {
        NodeValues node_x = new NodeValues(null, 0, x);
        NodeValues node_y = new NodeValues(null, 0, y);
        isCousins(root, null, node_x, node_y, 0);
        //Nodes can not be root
        return node_x.depth != 0 && node_x.parent != node_y.parent && node_x.depth == node_y.depth;
    }

    //Method uses recusion to find the depth and parents
    public void isCousins(TreeNode node, TreeNode parent, NodeValues node_x, NodeValues node_y, int depth) {
        if (node == null)
            return;
        if (node.val == node_x.value) {
            node_x.parent = parent;
            node_x.depth = depth;
        }
        if (node.val == node_y.value) {
            node_y.parent = parent;
            node_y.depth = depth;
        }
        isCousins(node.right, node, node_x, node_y, depth + 1);
        isCousins(node.left, node, node_x, node_y, depth + 1);
    }

    //Record to store dpeth and parent
    public class NodeValues {
        TreeNode parent;
        int depth;
        int value;

        public NodeValues(TreeNode _parent, int _depth, int _value) {
            parent = _parent;
            depth = _depth;
            value = _value;
        }
    }
}