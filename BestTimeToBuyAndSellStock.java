//Date: 3/28/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Best Time to Buy and Sell Stock

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing 
a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. 
If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 
Constraints:
1 <= prices.length <= 10^5
0 <= prices[i] <= 10^4
*/

import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] array = {7,1,5,3,6,4};
        System.out.println(maxProfit(array));
    }
    
    //My first attempt to the problem first by finding maxes and their respective ranges
    //then calculating the best difference within those ranges
    public static int maxProfit(int[] prices) {

        //Max price available
        int max = prices[prices.length-1];
        //Store max price available with index (time) 
        //Range for which max value is avialble will be 0 < x < index
        //Stock must be bought before it is sold
        List<int[]> pairList = new ArrayList<>();
        //Insert last max with index
        pairList.add(new int[]{prices.length-1, max});

        //Iterate from right to left storing the max with the ranges
        //The highest max will be in the front
        for (int i = prices.length-2; i > 0; --i) {
            //Greater max, found
            if (prices[i] > max) {
                max = prices[i];
                //Insert high max in the front to mantain increasing order or indexes
                pairList.add(0, new int[] {i, max});
            }
        }

        //Store the first max's index (time)
        int max_time = pairList.get(0)[0];
        //Store the max's value
        max = pairList.get(0)[1];
        //Store the max's profit, with the first value
        int max_profit = max - prices[0];
        //Index of max's pairList
        int max_index = 0;

        //Iterate from left to right to find the maximum difference
        for (int i = 0; i < prices.length-1; ++i) {
            //Max no longer has a valid sell date, get new max with time further out
            if (i >= max_time) {
                ++max_index;
                max_time = pairList.get(max_index)[0];
                max = pairList.get(max_index)[1];
            }
            //If value creates greater profit store it
            if (max_profit < max - prices[i])
                max_profit = max - prices[i];
        }

        //Profit must not be negative 
        if (max_profit > 0)
            return max_profit;

        //Profit was negative return 0
        return 0;
    }

    //Fast algorithm using only one iteration
    public int maxProfitFaster(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            //Cheaper price found to buy
            if (prices[i] < buy)
                buy = prices[i];
            //If difference is better change profits 
            else if (prices[i] - buy > profit)
                profit = prices[i] - buy;
        }
        return profit;
    }
}
