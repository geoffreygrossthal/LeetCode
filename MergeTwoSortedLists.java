//Date: 2/26/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Merge Two Sorted Lists

/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by 
splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 
Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
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

public class MergeTwoSortedLists {

    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode merged = new ListNode();
        ListNode current = merged;
    
        //Merge the lists until one of them becomes null
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                //Append list1 is lesser val
                current.next = list1;
                list1 = list1.next;
            } else {
                //Append list2 is lisser val
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
    
        //Append the remaining nodes from the non-null list
        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }
    
        //Return the merged list excluding the dummy node
        return merged.next;
    }

}