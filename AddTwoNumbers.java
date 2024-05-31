//Date: 5/31/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Add Two Numbers

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, 
and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 
Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
*/

public class AddTwoNumbers {

    //Method returns the resulting list of adding the each elements of two list
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersRec(l1, l2, 0);
    }

    //Recursive method to add two lists given a carry
    private ListNode addTwoNumbersRec(ListNode l1, ListNode l2, int carry) {
        //Carry
        boolean carry_present;
        //Sum value
        int sum_value;
        //Intialize a sum node
        ListNode sum = null;
        //End of both lists, add carry node if necessary
        if (l1 == null && l2 == null) {
            if (carry == 1)
                sum = new ListNode(1);
        }
        //Only l1 has nodes left
        else if (l2 == null) {
            sum_value = l1.val + carry;
            //Recursive call with carry
            if (twoDigits(sum_value)) {
                sum = new ListNode(0);
                sum.next = addTwoNumbersRec(l1.next, l2, 1);
            }
            //No carry present
            else {
                sum = new ListNode(sum_value);
                sum.next = addTwoNumbersRec(l1.next, l2, 0);
            }
        }
        //Only l2 has nodes left
        else if (l1 == null) {
            sum_value = l2.val + carry;
            //Recursive call with carry
            if (twoDigits(sum_value)) {
                sum = new ListNode(0);
                sum.next = addTwoNumbersRec(l1, l2.next, 1);
            }
            else {
                sum = new ListNode(sum_value);
                sum.next = addTwoNumbersRec(l1, l2.next, 0);
            }
        }
        //Nodes are present in both l1 and l2
        else {
            sum_value = l2.val + l1.val + carry;
            sum = new ListNode(sum_value % 10);
            //Recursive call with carry
            if (twoDigits(sum_value))
                sum.next = addTwoNumbersRec(l1.next, l2.next, 1);
            else
                sum.next = addTwoNumbersRec(l1.next, l2.next, 0);
        }
        //Return node with sum
        return sum;
    }

    //Method will return true if number is two digits
    private boolean twoDigits(int value) {
        if (value > 9)
            return true;
        else
            return false;
    }
}