//Date: 2/22/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Longest Common Prefix

/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 
Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
*/

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] array = {"flower","flow","flight"};
        String test = longestCommonPrefix(array);
        System.out.println(test);
    }
    
    public static String longestCommonPrefix(String[] strs) {
        
        char previous;
        int longest_index = 0;

        //The longest prefix will be equal or shorter than a single string
        for (int i = 0; i < strs[0].length(); ++i) {
            previous = strs[0].charAt(i);
            //Test that every string contains the same letter at the same index, except first string
            for (int index = 1; index < strs.length; ++index) {
                //String is out of range or no match at index, return longest
                if (strs[index].length() <= i || previous != strs[index].charAt(i)) {
                    return strs[0].substring(0, longest_index);
                }
            }
            ++longest_index;
        }

        return strs[0].substring(0, longest_index);
    }
}
