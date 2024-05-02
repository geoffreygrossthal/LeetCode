//Date: 5/2/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Find Mode in Binary Search Tree

/*
Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., 
the most frequently occurred element) in it.
If the tree has more than one mode, return them in any order.

Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 
Example 1:
Input: root = [1,null,2,2]
Output: [2]

Example 2:
Input: root = [0]
Output: [0]
 
Constraints:
The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeInBinarySearchTree {

    //Method returns the mode(s) of a binary search tree
    public int[] findMode(TreeNode root) {

        //Traverse the tree and add the mdoes to an array list
        List<Integer> modes_list = new ArrayList<>();
        //[0] is current value, [1] is max count, [2] is current count
        int[] values = new int[3];
        values[0] = 0;
        values[0] = 0;
        values[0] = 0;
        findMode(root, values, modes_list);

        //Add values to array to return
        int[] modes = new int[modes_list.size()];
        for (int i = 0; i < modes.length; i++)
            modes[i] = modes_list.get(i);
        return modes;
    }

    //Method is a helper function does inorder traversal (smallest to largest numbers)
    //and stores the modes (max freqeuncies), inorder traversal is needed becuase it will
    //consecutively encounters the number from smallest to largest so the freqeuncy of each
    //element can be counted easisly
    //Largest to smallest traversal can be applied also
    private void findMode(TreeNode node, int[] values, List<Integer> modes) {
        if (node == null)
            return;
        findMode(node.left, values, modes);
        values[2] = (node.val == values[0]) ? values[2] + 1 : 1;
        if (values[2] == values[1])
            modes.add(node.val);
        else if (values[2] > values[1]) {
            values[1] = values[2];
            modes.clear();
            modes.add(node.val);
        }
        values[0] = node.val;
        findMode(node.right, values, modes);
    }

    
    //Method returns the mode(s) of a binary search tree
    public int[] findModeSlower(TreeNode root) {

        //HashMap to store numbers with frequencies
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        //Recurse through tree to find frequencies
        findModeSlower(root, frequencyMap);

        //Find max frequency (mode), with number of occurences with the max freqeuncy
        int maxFrequency = 0;
        for (int frequency : frequencyMap.values()) {
            if (frequency > maxFrequency)
                maxFrequency = frequency;
        }

        //Collect values with max frequency (modes)
        int numOfModes = 0;
        List<Integer> maxFrequencyValues = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            //Insert the modes 
            if (entry.getValue() == maxFrequency) {
                maxFrequencyValues.add(entry.getKey());
                ++numOfModes;
            }
        }

        //Add values to array to return
        int[] modes = new int[numOfModes];
        for (int i = 0; i < numOfModes; i++)
            modes[i] = maxFrequencyValues.get(i);

        return modes;
    }

    //Method is helper function for counting the frequecnies in a binary tree
    private void findModeSlower(TreeNode node, HashMap<Integer, Integer> frequencyMap) {
        //Reach end of path return
        if (node == null)
            return;
        else {
            //Increment frequency if the element is already in the map
            if (frequencyMap.containsKey(node.val))
                frequencyMap.put(node.val, frequencyMap.get(node.val) + 1);
            //Otherwise, add the element to the map with frequency 1
            else
                frequencyMap.put(node.val, 1);
            //Serch left and right branches
            findModeSlower(node.left, frequencyMap);
            findModeSlower(node.right, frequencyMap);
        }
    }
}
