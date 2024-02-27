//Date: 2/27/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Find Index of the First Occurrence ing a String

/*
Given two strings needle and haystack, return the index of the first
occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 
Constraints:
1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
*/

public class FindIndexOfFirstOccurrenceInString {

    public static void main(String[] args) {
        strStr("a", "a");
    }


    public static int strStr(String haystack, String needle) {

        //Needle cannot be bigger than haystack
        if (needle.length() > haystack.length())
            return -1;

        //Starting char for possible haystack index, and needle starting char
        char c1, c1_needle = needle.charAt(0);
        
        //Iterate to haystack.length() - needle.length(), max possible starting index
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            c1 = haystack.charAt(i);
            if (c1 != c1_needle)
                continue;
            if (needle.equals(haystack.substring(i, i+needle.length())))
                return i;
        }

        //No occurrence return -1
        return -1;
    }
}
