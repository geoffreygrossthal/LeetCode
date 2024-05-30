//Date: 5/30/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem N-ary Tree PostOrderTraversal

/*
Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal. 
Each group of children is separated by the null value (See examples)

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [5,6,3,2,4,1]

Example 2:
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 
Constraints:
The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The height of the n-ary tree is less than or equal to 1000.
 
Follow up: Recursive solution is trivial, could you do it iteratively?
*/

public class NaryTreePostorderTraversal {

    //Method returns the postorder traversal of an N-ary tree
    public List<Integer> postorder(Node root) {
        List<Integer> postorder = new ArrayList<>();
        postorderRec(postorder, root);
        return postorder;
    }

    //Method recurses through N-ary tree preorder and adds nodes to list
    private void postorderRec(List<Integer> postorder, Node current) {
        //No more nodes return
        if (current == null)
            return;
        //Recurse through all N children, left most first
        for (Node child : current.children)
            postorderRec(postorder, child);
        //Add value to list after recursive calls
        postorder.add(current.val);
    }
}