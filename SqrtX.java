//Date: 2/5/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Sqrt(x)

/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. 
The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.
For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 
Example 1:
Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.

Example 2:
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer,
2 is returned.
 
Constraints:
0 <= x <= 231 - 1
*/



public class SqrtX {
    
    public static void main(String[] args) {
        System.out.println(mySqrt(9));
    }

    public static int mySqrt(int x) {

        //Base case x is either 0 or 1, qrt is the same as x
        if(x <= 1) 
            return x;
        

        //Intialize values to perform search
        int start = 1, end = (x/2)+1, sqrt = 0; 
        //Use long to prevent integer overflow when squaring
        long mid = 0;

        //Binary search
        while(start <= end) {
            //Calculate the middle value
            mid = (start + end) / 2;
            //If mid^2 equals the x return it
            if(mid * mid == x) {
                return (int) mid;
            } 
            //mid^2 is to small, serch larger
            else if(mid * mid < x) {
                start = (int) mid + 1;
                sqrt = (int) mid;
            //mid^2 is to large, search lower
            } else {
                end = (int) mid - 1;
            }
        }

        return sqrt;
    }
}
