//Date: 5/30/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem N-ary Tree Preorder Traversal

/*
Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal. Each 
group of children is separated by the null value (See examples)

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]

Example 2:
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 
Constraints:
The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The height of the n-ary tree is less than or equal to 1000.
 
Follow up: Recursive solution is trivial, could you do it iteratively?
*/

public class NaryTreePreorderTraversal {

    //Method returns the preorder traversal of a N-ary tree
    public List<Integer> preorder(Node root) {
        List<Integer> preorder = new ArrayList<>();
        preorderRec(preorder, root);
        return preorder;
    }

    //Method recurses through N-ary tree preorder and 
    //adds nodes to list
    private void preorderRec(List<Integer> preorder, Node current) {
        //No more nodes return
        if (current == null)
            return;
        //Add value to list first
        preorder.add(current.val);
        //Recurse through all N children
        for (Node child : current.children) {
            //Recurse left most first
            preorderRec(preorder, child);
        }
    }
}