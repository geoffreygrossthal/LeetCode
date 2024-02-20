//Date: 2/16/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Range Sum of BST

/*
Given the root node of a binary search tree and two integers low and high,
return the sum of values of all nodes with a value in the inclusive range [low, high].

Example 1:
Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

Example 2:
Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 

Constraints:
The number of nodes in the tree is in the range [1, 2 * 104].
1 <= Node.val <= 105
1 <= low <= high <= 105
All Node.val are unique.
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class RangeSumOfBST {

    public static void Main(String[] args) {

    }

    //Faster solution beat 100%, does not explore unesscesary branches
    public int rangeSumBST(TreeNode root, int low, int high) {

        int sum = 0;

        //End of branch return 0
        if (root == null)
            return sum;

        //Within range add value to sum
        if (low <= root.val && root.val <= high)
            sum += root.val;

        //Encountered low range only explore higher values
        if (root.val <= low)
            sum += rangeSumBST(root.right, low, high);
        //Ecnoutnered high range only explore lower values
        else if (high <= root.val)
            sum += rangeSumBST(root.left, low, high); 
        //Explore both left and right within range
        else {
            sum += rangeSumBST(root.left, low, high);
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
    }

    //Valid solution, trying to find faster solution, beat around 50%
    public int rangeSumBSTSlower(TreeNode root, int low, int high) {
        
        int sum = 0;

        if (root == null)
            return sum;

        if (low <= root.val && root.val <= high)
            sum += root.val;

        sum += rangeSumBST(root.left, low, high);
        sum += rangeSumBST(root.right, low, high);
        return sum;
    }
}