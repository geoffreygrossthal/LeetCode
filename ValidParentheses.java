//Date: 2/23/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Valid Parentheses

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 
Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {

        char c;
        Stack<Character> charStack = new Stack<>();

        //Iterate through string
        for (int i = 0; i < s.length(); ++i) {
            c = s.charAt(i);
            //Push on stack
            if (c == '[' || c == '{' || c == '(') 
                charStack.push(c);
            else if (c == ']') {
                //Not valid
                if (charStack.isEmpty() || '[' != charStack.peek())
                    return false;
                else
                    charStack.pop();
            }
            else if (c == '}') {
                //Not valid
                if (charStack.isEmpty() || '{' != charStack.peek())
                    return false;
                else
                    charStack.pop();
            }
            else if (c == ')') {
                //Not valid
                if (charStack.isEmpty() || '(' != charStack.peek())
                    return false;
                else
                    charStack.pop();
            }
            else
                return false;
        }

        //Stack was empty return true
        return charStack.isEmpty();
    }

    //Prints the stack for debugging
    public static void printStack(Stack<Character> stack) {
        System.out.println("Stack elements from top to bottom:");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }
}