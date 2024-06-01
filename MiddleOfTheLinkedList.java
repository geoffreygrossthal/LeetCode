//Date: 6/1/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Middle of the Linked List

/*
Given the head of a singly linked list, 
return the middle node of the linked list.
If there are two middle nodes, return the second middle node.

Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 
Constraints:
The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100
*/

public class MiddleOfTheLinkedList {

    //Method returns the middle node of the a linkedList, if even number of 
    //nodes returns the second middle
    public ListNode middleNode(ListNode head) {
        ArrayList<ListNode> nodeList = new ArrayList<>();
        storeNodesInList(nodeList, head);
        return nodeList.get(nodeList.size() / 2);
    }

    //Method stores the nodes in a list in array list
    private void storeNodesInList(ArrayList<ListNode> nodeList, ListNode node) {
        if (node == null)
            return;
        nodeList.add(node);
        storeNodesInList(nodeList, node.next);
    }
}