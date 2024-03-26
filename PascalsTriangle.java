//Date: 3/26/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Pascal's Triangle

/*
Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly 
above it as shown:

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]
 
Constraints:
1 <= numRows <= 30
*/

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    
    //Method generates Pascal's Trigangle
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal_triangle = new ArrayList<>();
        recursiveGenerate(pascal_triangle, 1, numRows);
        return pascal_triangle;
    }

    //Recursive function to generate Pascal's triangle
    private void recursiveGenerate(List<List<Integer>> pascal_triangle, int currentRow, int numRows) {
        //Stop executing number of rows are less than current
        if (currentRow > numRows)
            return;
        //New row to insert into triangle
        List<Integer> row = new ArrayList<>();
        //First row always starts with a single 1
        if (currentRow == 1) {
            row.add(1);
            pascal_triangle.add(row);
        }
        //Second row always starts with two 1s
        else if (currentRow == 2) {
            row.add(1);
            row.add(1);
            pascal_triangle.add(row);
        }
        else {
            //Loop to populate any row greater than 2
            for (int i = 0; i < currentRow; ++i) {
                //First and last have 1
                if (i == 0 || i == currentRow-1) {
                    row.add(1);
                }
                //Add both diagnol parent numbers
                else {
                    int left = pascal_triangle.get(currentRow-2).get(i-1);
                    int right = pascal_triangle.get(currentRow-2).get(i);
                    row.add(left+right);
                }
            }
            pascal_triangle.add(row);
        }
        //Another row to add call method again
        recursiveGenerate(pascal_triangle, currentRow+1, numRows);
    }
}
