//Date: 7/22/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Merge K Sorted Lists

/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 
Constraints:
k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
*/

public class MergeKSortedLists {

    //Method recieves an array of sorted lists and returns a signle sorted list
    public ListNode MergeKLists(ListNode[] lists) {

        //Store all node values inside of binary tree
        int tree_size = 0;
        ListNode temp = null;
        BinarySearchTree tree = new BinarySearchTree();
        for (int row = 0; row < lists.Length; ++row) {
            temp = lists[row];
            while (temp != null) {
                tree.Insert(temp.val);
                ++tree_size;
                temp = temp.next;
            }
        }

        //Iterate through the binary search tree and add the elements smallest to largest to the list
        ListNode current = null;
        ListNode head = null;
        TreeNode temp_tree_node = null;
        for (int i = 0; i < tree_size; ++i) {
            if (head == null) {
                temp_tree_node = tree.RemoveAndReturnMin();
                head = new ListNode(temp_tree_node.val);
                current = head;
            }
            else {
                temp_tree_node = tree.RemoveAndReturnMin();
                current.next = new ListNode(temp_tree_node.val);
                current = current.next;
            }
        }
        return head;
    }

    public class BinarySearchTree {
        
        public TreeNode root;

        //Constructor
        public BinarySearchTree() {
            root = null;
        }

        //Method to insert a new node with given value into BST
        public void Insert(int val) {
            root = InsertRecursive(root, val);
        }

        //Recursive function to insert a new node into BST allowing duplicates
        private TreeNode InsertRecursive(TreeNode node, int val) {
            //Base case: if the tree is empty, return a new node
            if (node == null)
                return new TreeNode(val);

            //Recursive case: insert into the appropriate subtree
            if (val <= node.val)
                node.left = InsertRecursive(node.left, val);
            else
                node.right = InsertRecursive(node.right, val);

            //Return the updated node
            return node;
        }

        //Method to remove and return the node with minimum value from BST
        public TreeNode RemoveAndReturnMin() {
            TreeNode minNode = FindMin(root);
            root = RemoveRecursive(root, minNode.val); 
            return minNode; 
        }

        //Method to find the node with the minimum value in BST
        public TreeNode FindMin(TreeNode node) {
            //Traverse left until the leftmost node is found
            while (node.left != null)
                node = node.left;
            return node;
        }

        //Recursive function to remove a node with a specific value from BST
        public TreeNode RemoveRecursive(TreeNode node, int val) {
            
            //Base case: if the tree is empty
            if (node == null)
                return null;

            //Recursive case: traverse the tree to find the node to remove
            if (val < node.val)
                node.left = RemoveRecursive(node.left, val);
            else if (val > node.val)
                node.right = RemoveRecursive(node.right, val);
            else {
                //Case 1: Node to be deleted has no children or only one child
                if (node.left == null)
                    return node.right;
                else if (node.right == null)
                    return node.left;

                //Case 2: Node to be deleted has two children
                //Find the minimum value node in the right subtree (successor)
                TreeNode successor = FindMin(node.right);
                //Replace the node's value with the successor's value
                node.val = successor.val;
                //Remove the successor node from the right subtree
                node.right = RemoveRecursive(node.right, successor.val);
            }

            return node;
        }

        //Method to print BST in-order
        public void PrintInOrder() {
            PrintInOrderRecursive(root);
            Console.WriteLine(); // Print a newline at the end
        }

        //Helper method for in-order traversal
        private void PrintInOrderRecursive(TreeNode node) {
            if (node != null) {
                PrintInOrderRecursive(node.left); // Traverse left subtree
                Console.Write(node.val + " "); // Print node value
                PrintInOrderRecursive(node.right); // Traverse right subtree
            }
        }
    }

    //Class to represent a single tree node 
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}