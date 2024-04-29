//Date: 4/29/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Binary Tree Paths

/*
Given the root of a binary tree, return all root-to-leaf paths in any order.
A leaf is a node with no children.

Example 1:
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]

Example 2:
Input: root = [1]
Output: ["1"]
 
Constraints:
The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100
*/

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        binaryTreePathsRecursive(root, paths, "");
        return paths;
    }

    private void binaryTreePathsRecursive(TreeNode node, List<String> paths, String path) {
        if (node.left == null && node.right == null)
            paths.add(path + node.val);
        else if (node.right == null)
            binaryTreePathsRecursive(node.left, paths, path + node.val + "->");
        else if (node.left == null)
            binaryTreePathsRecursive(node.right, paths, path + node.val + "->");
        else {
            path += node.val + "->";
            binaryTreePathsRecursive(node.left, paths, path);
            binaryTreePathsRecursive(node.right, paths, path);
        }
    }
}
