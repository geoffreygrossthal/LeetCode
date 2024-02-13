//Date: 1/17/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Unique Number Of Occurrences

/*
Given an array of integers arr, return true if the number of occurrences of 
each value in the array is unique or false otherwise.

Example 1:
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

Example 2:
Input: arr = [1,2]
Output: false

Example 3:
Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true

Constraints:
1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {

    public static void main(String[] args) {

    }

    //Returns the true if unique number of occurrences otherwise false
    public static boolean uniqueOccurrences(int[] arr) {
        
        //Hash map to store number of occurences of each int
        Map<Integer, Integer> myMap = new HashMap<>();

        //Itrate through array and add occurrences
        for (int i = 0; i < arr.length; ++i) {
             //Check if the key is already present in the map
             if (myMap.containsKey(arr[i])) {
                //Increment the value if the key is present
                myMap.put(arr[i], myMap.get(arr[i]) + 1);
            } else {
                //Initialize the key with a count of 1 if not present
                myMap.put(arr[i], 1);
            }
        }

        //If duplicates are present return false
        if (hasDuplicateValues(myMap))
            return false;

        //Return true no duplicates
        return true;
    }

    //Method to return true if there are duplicates
    private static boolean hasDuplicateValues(Map<Integer, Integer> map) {
        //Intialize set
        Set<Integer> valueSet = new HashSet<>();
        //Iterate through set and add values which denote occurences
        for (Integer value : map.values()) {
            //If value (number or occurrences of unique element) is already present, duplicates are present
            if (!valueSet.add(value)) {
                return true;
            }
        }
        return false;
    }
}
