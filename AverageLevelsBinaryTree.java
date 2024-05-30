//Date: 5/30/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Average Levels in Binary Tree

/*
Given the root of a binary tree, return the average value of the nodes on each 
level in the form of an array. Answers within 10-5 of the actual answer will 
be accepted.
 
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, 
and on level 2 is 11.
Hence return [3, 14.5, 11].

Example 2:
Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]
 
Constraints:
The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
*/

public class AvergeLevelsBinaryTree {

    //Method calculates the average of each level in a binary tree
    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, Record> hashMap = new HashMap<>();
        averageOfLevelsRec(hashMap, root, 0);
        List<Double> averages = new ArrayList<>();
        for (Map.Entry<Integer, Record> entry : hashMap.entrySet()) {
            Record record = entry.getValue();
            double average = (double) record.sum_level / record.number_nodes_level;
            averages.add(average);
        }
        return averages;
    }

    //Recursive helper method to find the average of each level
    private void averageOfLevelsRec(Map<Integer, Record> hashMap, TreeNode root, int level) {
        if (root == null)
            return;
        //Create record for level
        Record node_values;
        if (!hashMap.containsKey(level)) {
            node_values = new Record();
            node_values.sum_level = (long) root.val;
            node_values.number_nodes_level = 1;
            hashMap.put(level, node_values);
        } 
        else {
            node_values = hashMap.get(level);
            node_values.sum_level += root.val;
            node_values.number_nodes_level += 1;
        }
        //Increment level with recursive call
        averageOfLevelsRec(hashMap, root.left, level + 1);
        averageOfLevelsRec(hashMap, root.right, level + 1);
    }

    //Private class to store sum of level and number of nodes per level
    private static class Record {
        long sum_level;
        int number_nodes_level;
    }
}
