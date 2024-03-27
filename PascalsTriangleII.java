//Date: 3/27/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Pascal's TriangleII

/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: rowIndex = 3
Output: [1,3,3,1]

Example 2:
Input: rowIndex = 0
Output: [1]

Example 3:
Input: rowIndex = 1
Output: [1,1]
 
Constraints:
0 <= rowIndex <= 33
Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalsTriangleII {

    public static void main(String[] args) {
        getRow(31);
    }
    
    //Builds a specific row of Pascal's Triangle
    public static List<Integer> getRow(int rowIndex) {

        int element;
        //Store row of Pascal's Triangle
        List<Integer> row_of_triangle = new ArrayList<>();
        //Memorizes values in triangle
        Map<String, Integer> memorizationMap = new HashMap<>();

        //0 row
        if (rowIndex == 0) {
            row_of_triangle.add(1);
            return row_of_triangle;
        }

        //Add all elements aside from middle with the corresponding equal right and lef side
        for (int i = 0; i < (int) Math.ceil((double)rowIndex / 2); ++i) {
            element = getValuePascalTri(i, rowIndex, memorizationMap);
            //Add to left side of row
            row_of_triangle.add(i, element);
            //Add to corresponding right side
            row_of_triangle.add(row_of_triangle.size() - i, element);
        }

        //If row has middle element add it
        if (rowIndex % 2 == 0) {
            element = getValuePascalTri(rowIndex/2, rowIndex, memorizationMap);
            row_of_triangle.add(rowIndex/2, element);
        }

        return row_of_triangle;
    }

    //Returns the value of Pascall's triangle given row and index
    private static int getValuePascalTri(int index, int row, Map<String, Integer> memorizationMap) {
        //First index is always 1
        if (index == 0)
            return 1;
        //Second index is always row
        if (index == 1)
            return row;
        //Find values for indexs greater than 2
        return pascalsTriRecursive(index, row, memorizationMap);
    }

    //Recurisve function to calculate Pascall's triangle
    public static int pascalsTriRecursive(int index, int row, Map<String, Integer> memorizationMap) {
        
        //Base case
        if (index == 0 || index == row)
            return 1;

        //If value is already caluclated, retireve it from memory
        String key = index + "," + row;
        if (memorizationMap.containsKey(key)) 
            return memorizationMap.get(key);

        //Recursive call if value is unknown
        int result = pascalsTriRecursive(index - 1, row - 1, memorizationMap) + pascalsTriRecursive(index, row - 1, memorizationMap);
        memorizationMap.put(key, result);
        return result;
    }
}
