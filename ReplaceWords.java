//Date: 6/6/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Replace Words

/*
In English, we have a concept called root, which can be followed by some other 
word to form another longer word - let's call this word derivative. For example, 
when the root "help" is followed by the word "ful", we can form a derivative 
"helpful". Given a dictionary consisting of many roots and a sentence 
consisting of words separated by spaces, replace all the derivatives in the 
sentence with the root forming it. If a derivative can be replaced by more 
than one root, replace it with the root that has the shortest length.
Return the sentence after the replacement.

Example 1:
Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"

Example 2:
Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"
 
Constraints:
1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 100
dictionary[i] consists of only lower-case letters.
1 <= sentence.length <= 106
sentence consists of only lower-case letters and spaces.
The number of words in sentence is in the range [1, 1000]
The length of each word in sentence is in the range [1, 1000]
Every two consecutive words in sentence will be separated by exactly one space.
sentence does not have leading or trailing spaces.
*/

public class ReplaceWords {

    //Method replaces all derivatives in the setence with the shortest roots
    public String replaceWords(List<String> dictionary, String sentence) {

        //Resulting new sentence with derivatives replaced with shortest roots
        StringBuilder rootSentence = new StringBuilder();
        
        //Sort the dictionary based on string lengths from smallest to largest
        Collections.sort(dictionary, Comparator.comparingInt(String::length));

        //Iterate through the sentence replacing all derivatives with roots
        int wordStart = 0;
        while (wordStart < sentence.length()) {
            //Don't search for spaces in dictionary but append to resulting sentence
            if (sentence.charAt(wordStart) == ' ') {
                rootSentence.append(' ');
                wordStart++;
                continue;
            }
            int wordEnd = getWordEnd(sentence, wordStart);
            String derivative = sentence.substring(wordStart, wordEnd + 1);
            int shortestRootIndex = getShortestRoot(dictionary, derivative);
            if (shortestRootIndex != -1)
                rootSentence.append(dictionary.get(shortestRootIndex));
            //No root found keep the original
            else
                rootSentence.append(derivative);
            wordStart = wordEnd + 1;
        }
        return rootSentence.toString();
    }

    //Method returns the index of the shortest root given a derivative and dictionary, if none is found returns -1
    private int getShortestRoot(List<String> dictionary, String derivative) {
        for (int i = 0; i < dictionary.size(); i++) {
            String root = dictionary.get(i);
            if (root.length() >= derivative.length()) {
                return -1;
            } else if (derivative.startsWith(root)) {
                return i;
            }
        }
        return -1;
    }

    //Method returns the ending index of a word given the starting index
    private int getWordEnd(String sentence, int start) {
        int i = start;
        while (i < sentence.length() && sentence.charAt(i) != ' ') {
            i++;
        }
        return i - 1;
    }
}