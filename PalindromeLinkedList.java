//Date: 1/16/2023
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Palindrome Linked List

/*
Given the head of a singly linked list, return true if it is a 
palindrome or false otherwise.

Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false

Constraints:
The number of nodes in the list is in the range [1, 10^5].
0 <= Node.val <= 9
*/

import java.util.Scanner;

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

public class PalindromeLinkedList {

    public static void main(String[] args) {

        int num;
        Scanner kb = new Scanner(System.in);
        ListNode head = null;
        ListNode current = null;


        do {

            System.out.print("Enter an int for the list or -1 to exit: ");
            num = kb.nextInt();

            if (num != -1) {
                ListNode newNode = new ListNode(num);
                if (head == null) {
                    //If the list is empty, set both head and current to the new node
                    head = newNode;
                    current = newNode;
                } else {
                    // Add the new node to the end of the list and move current to the new node
                    current.next = newNode;
                    current = newNode;
                }
            }
        } while (num != -1);

        printLinkedList(head);
        boolean var = isPalindrome(head);
        System.out.println("Is a palindrome: " + var);
        kb.close();
    }

    public static boolean isPalindrome(ListNode head) {

        //Empty string is a palindrome or single int
        if (head == null || head.next == null)
            return true;

        
        //Array to store numbers with max size 10^5 = 100000
        int[] numbers = new int[100000];

        //Size of elements
        int size = 0;

        //Transfer data to array for easy transversal
        while (head != null) {
            numbers[size] = head.val;
            ++size;
            head = head.next;
        }
        
        //Iterate halfway through array to test if it is a palindrome or not
        for (int i = 0; i < size; ++i) {
            //Not a palidrome
            if (numbers[i] != numbers[size-1]) {
                return false;
            }
            //Iterate down array
            --size;
        }
        return true;
    }

    //Prints the linked list
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        //Print a new line after printing all elements
        System.out.println();
    }
}