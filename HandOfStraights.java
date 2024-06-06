//Date: 6/6/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Hand Of Straights

/*
Alice has some number of cards and she wants to rearrange the cards into 
groups so that each group is of size groupSize, and consists of groupSize 
consecutive cards. Given an integer array hand where hand[i] is the value 
written on the ith card and an integer groupSize, return true if she can 
rearrange the cards, or false otherwise.

Example 1:
Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]

Example 2:
Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4.

Constraints:
1 <= hand.length <= 104
0 <= hand[i] <= 109
1 <= groupSize <= hand.length
*/

import java.util.TreeMap;

public class HandOfStraights {

    //Method returns true if cards can be rearranged otherwise false
    public boolean isNStraightHand(int[] hand, int groupSize) {

        //Single element will always be true, no need to check
        if (groupSize == 1)
            return true;
        
        TreeMap<Integer, Integer> numberFrequency = new TreeMap<>();
        
        //Count the numbers (indexes) and frequencies
        for (int num : hand)
            numberFrequency.put(num, numberFrequency.getOrDefault(num, 0) + 1);

        //Make sure all elements in the tree map are part of an increasing hand
        while (!numberFrequency.isEmpty()) {
            int startNum = numberFrequency.firstKey();
            for (int num = startNum; num < startNum + groupSize; num++) {
                //Need frequency not present return false
                if (!numberFrequency.containsKey(num))
                    return false;
                int frequency = numberFrequency.get(num);
                //If frequency becomes 0 remove entry
                if (frequency == 1)
                    numberFrequency.remove(num);
                //Update the frequency of the tree map
                else
                    numberFrequency.put(num, frequency - 1);
            }
        }

        //Hands with increasing frequencies were accounted for, return true
        return true;
    }
}