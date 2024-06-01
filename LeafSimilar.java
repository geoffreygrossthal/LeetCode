//Date: 6/1/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Leaf Similar

/*
Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
Two binary trees are considered leaf-similar if their leaf value sequence is the same.
Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

Example 1:
Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true

Example 2:
Input: root1 = [1,2,3], root2 = [1,3,2]
Output: false
 
Constraints:
The number of nodes in each tree will be in the range [1, 200].
Both of the given trees will have values in the range [0, 200].
*/

public class LeafSimilar {

    //Method returns true if two trees are leaf similar, otherwise false
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<Integer> root1LeafsQueue = new LinkedList<>();
        storeRoot1Queue(root1, root1LeafsQueue);
        return matchLeafs(root2, root1LeafsQueue) && root1LeafsQueue.isEmpty();
    }

    //Method matches the leafs from root1 with root2. If equal returns true, otherwise false
    private boolean matchLeafs(TreeNode node2, Queue<Integer> root1LeafsQueue) {
        if (node2 == null)
            return true;
        else if (isLeaf(node2)) {
            if (root1LeafsQueue.isEmpty() || node2.val != root1LeafsQueue.poll())
                return false;
        } 
        else {
            if (!matchLeafs(node2.left, root1LeafsQueue) || !matchLeafs(node2.right, root1LeafsQueue))
                return false;
        }
        return true;
    }

    //Method stores root1's leaf on the stack from left to right
    private void storeRoot1Queue(TreeNode node1, Queue<Integer> root1LeafsQueue) {
        if (node1 == null)
            return;
        else if (isLeaf(node1))
            root1LeafsQueue.offer(node1.val);
        else {
            storeRoot1Queue(node1.left, root1LeafsQueue);
            storeRoot1Queue(node1.right, root1LeafsQueue);
        }
    }

    //Method returns true if a node is a leaf, otherwise false
    private boolean isLeaf(TreeNode leaf) {
        return leaf.left == null && leaf.right == null;
    }
}