//Date: 6/1/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Remove Linked List Elements

/*
Given the head of a linked list and an integer val, remove all the nodes of 
the linked list that has Node.val == val, and return the new head.

Example 1:
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Example 2:
Input: head = [], val = 1
Output: []

Example 3:
Input: head = [7,7,7,7], val = 7
Output: []
 
Constraints:
The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= val <= 50
*/


public class RemoveLinkedListElements {

    //Method removes all val from list
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0); 
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        while (current != null) {
            if (current.val == val)
                prev.next = current.next;
            else
                prev = current; 
            current = current.next;
        }
        return dummy.next;
    }
}