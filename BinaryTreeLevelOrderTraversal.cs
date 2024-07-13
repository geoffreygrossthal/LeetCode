//Date: 7/11/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Binary Tree Level Order Traversal

/*
Given the root of a binary tree, return the level order traversal of its nodes' values. 
(i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []
 
Constraints:
The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
*/

public class Solution {

    //Method order traversal of it's nodes values
    public IList<IList<int>> LevelOrder(TreeNode root) {
        IList<IList<int>> listOfLists = new List<IList<int>>();
        LevelOrder(root, listOfLists, 0);
        return listOfLists;
    }

    //Method is a recursive helper method to add numbers to list
    private void LevelOrder(TreeNode node, IList<IList<int>> listOfLists, int level) {
        //End of branch return
        if (node == null)
            return;
        //See if new list needs to be created for level
        else if (listOfLists.Count == level)
            listOfLists.Add(new List<int> { node.val });
        //Add value to correct level
        else {
            IList<int> listAtIndex = listOfLists[level];
            listAtIndex.Add(node.val);
        }
        //Recursive call for both left and right branches
        ++level;
        LevelOrder(node.left, listOfLists, level);
        LevelOrder(node.right, listOfLists, level);
    }
}