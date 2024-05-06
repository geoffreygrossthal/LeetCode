//Date: 5/2/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Minimum Absolute Difference

/*
Given the root of a Binary Search Tree (BST), return the minimum absolute difference 
between the values of any two different nodes in the tree.

Example 1:
Input: root = [4,2,6,1,3]
Output: 1

Example 2:
Input: root = [1,0,48,null,null,12,49]
Output: 1
 
Constraints:
The number of nodes in the tree is in the range [2, 104].
0 <= Node.val <= 105
*/

import java.util.ArrayList;

public class MinimumAbsoluteDifferenceBST {

    //Returns the minimum absolute difference in the tree
    public int getMinimumDifference(TreeNode root) {
        //Store values from smallest to largest in list
        ArrayList<Integer> values = new ArrayList<>();
        getMinimumDifference(values, root);
        //Iterate through values to calculate minimum difference
        int difference = values.get(1) - values.get(0), current_difference;
        for (int i = 1; i < values.size()-1; ++i) {
            current_difference = values.get(i+1) - values.get(i);
            if (current_difference < difference)
                difference = current_difference; 
        }
        return difference;
    }

    //Helper method to recursively add values from smallest to largest (In-order)
    private void getMinimumDifference(ArrayList<Integer> values, TreeNode node) {
        if (node == null)
            return;
        getMinimumDifference(values, node.left);
        values.add(node.val);
        getMinimumDifference(values, node.right);
    }
}
