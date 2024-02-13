//Date: 1/18/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Climbing Stairs

/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/

public class ClimbingStairs {

    public static void main(String[] args) {
        int result = climbStairs(10);
        System.out.println("Result: " + result);
    }

    public static int climbStairs(int n) {

        //Number of ways to climb the previous step
        int a = 0;
        //Number of ways to climb the current step
        int b = 1;

        //The sum of the way to reach the next step
        //is the sum of the ways to reach the previous two steps
        //Fibonacci Sequence
        int c = 0;

        //Iterate every step of the staircase
        for (int i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}