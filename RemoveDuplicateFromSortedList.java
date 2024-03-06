//Date: 3/6/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Remove Duplicate from Sorted List

/*
Given the head of a sorted linked list, delete all duplicates
such that each element appears only once. Return the linked list sorted as well.

Example 1:
Input: head = [1,1,2]
Output: [1,2]

Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]
 
Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
*/

class ListNode {

    int val;
    ListNode next;

    //Default Constructor
    ListNode() {
    }

    //Constructor given int
    ListNode(int val) { 
        this.val = val; 
    }

    //Constructor given int and next node
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}

public class RemoveDuplicateFromSortedList {
    
    public ListNode deleteDuplicates(ListNode head) {

        //Empty list return head
        if (head == null)
            return head;

        ListNode current = head;

        //Iterte through each unique val in the list
        while (current != null) {
            current.next = getNonDuplicate(current, current.val);
            current = current.next;
        }
        
        return head;
    }

    //Returns next node that is not duplicate
    public static ListNode getNonDuplicate(ListNode node, int val) {
        if (node == null)
            return null;
        else if (node.val == val)
            return getNonDuplicate(node.next, val);
        else
            return node;
    }
}
