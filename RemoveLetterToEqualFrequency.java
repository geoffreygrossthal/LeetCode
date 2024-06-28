//Date: 6/28/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Remove Letter To Equal Frequency

/*
You are given a 0-indexed string word, consisting of lowercase English letters. You need to select one 
index and remove the letter at that index from word so that the frequency of every letter present in 
word is equal. Return true if it is possible to remove one letter so that the frequency of all letters 
in word are equal, and false otherwise.

Note:
The frequency of a letter x is the number of times it occurs in the string.
You must remove exactly one letter and cannot choose to do nothing.
 
Example 1:
Input: word = "abcc"
Output: true
Explanation: Select index 3 and delete it: word becomes "abc" and each character has a frequency of 1.

Example 2:
Input: word = "aazz"
Output: false
Explanation: We must delete a character, so either the frequency of "a" is 1 and the frequency of "z" 
is 2, or vice versa. It is impossible to make all present letters have equal frequency.
 
Constraints:
2 <= word.length <= 100
word consists of lowercase English letters only.
*/

public class RemoveLetterToEqualFrequency {
    
    //Method returns true if one letter from the string was removed all letters would have the same freqeuency
    public boolean equalFrequency(String word) {
        
        char current_char;
        //Indexes represent chars 0 for a, 1 for b, etc
        int[] alphabet = new int[26];
        //Iterate throug string and count occurences of letters
        for (int i = 0; i < word.length(); ++i) {
            current_char = word.charAt(i);
            ++alphabet[current_char - 'a'];
        }

        //Find higest and lowest frequencies, start at possible valid indexes
        int highest = 0;
        for (int i = 1; i < 26; ++i) {
            if (alphabet[i] > alphabet[highest])
                highest = i;
        }
        int lowest = highest;
        for (int i = 0; i < 26; ++i) {
            if (alphabet[i] != 0 && alphabet[i] < alphabet[lowest])
                lowest = i;
        }

        //Return true if word contains only single characters
        if (alphabet[highest] == 1)
            return true;

        //Test if removing the higest or lowest frequency results in a equal distbrution
        boolean removed_highest = true;
        boolean removed_lowest = true;
        //Frequencies should be equal, if highest is removed
        --alphabet[highest];
        int frequency = alphabet[highest];
        for (int i = 0; i < 26; ++i) {
            if (alphabet[i] != 0 && alphabet[i] != frequency) {
                removed_highest = false;
                break;
            }
        }

        //Add back highest frequency, if the lowest is removed, remianing frequencies should be equal
        ++alphabet[highest];
        --alphabet[lowest];
        frequency = alphabet[highest];
        System.out.println("frequency: " + frequency);
        System.out.println("alphabet[lowest]: " + alphabet[lowest]);
        System.out.println("lowest: " + lowest);
        for (int i = 0; i < 26; ++i) {
            if (alphabet[i] != 0 && alphabet[i] != frequency) {
                removed_lowest = false;
                break;
            }
        }

        //If either is true return true
        return removed_lowest || removed_highest;
    }
}