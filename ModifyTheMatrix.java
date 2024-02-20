//Date: 2/20/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Modify the Mtrix

/*
Given a 0-indexed m x n integer matrix matrix, create a new 0-indexed matrix
called answer. Make answer equal to matrix, then replace each element with the
value -1 with the maximum element in its respective column.
Return the matrix answer.

Example 1:
Input: matrix = [[1,2,-1],[4,-1,6],[7,8,9]]
Output: [[1,2,9],[4,8,6],[7,8,9]]
Explanation: The diagram above shows the elements that are changed (in blue).
- We replace the value in the cell [1][1] with the maximum value in the column 1, that is 8.
- We replace the value in the cell [0][2] with the maximum value in the column 2, that is 9.

Example 2:
Input: matrix = [[3,-1],[5,2]]
Output: [[3,2],[5,2]]
Explanation: The diagram above shows the elements that are changed (in blue).
 
Constraints:
m == matrix.length
n == matrix[i].length
2 <= m, n <= 50
-1 <= matrix[i][j] <= 100
The input is generated such that each column contains at least one non-negative integer.
*/

public class ModifyTheMatrix {

    public int[][] modifiedMatrix(int[][] matrix) {
        
        int size_index_neg_one;
        int max = matrix[0][0];
        int[] index_neg_one;

        //Check each column of the matrix, num of columns = row size
        for (int i = 0; i < matrix[0].length; ++i) {
            //Iterate through columns to find max and -1 indexes
            index_neg_one = new int[matrix.length];
            size_index_neg_one = 0;
            max = matrix[0][i];
            for (int ix = 0; ix < matrix.length; ++ix) {
                if (matrix[ix][i] > max)
                    max = matrix[ix][i];
                else if (matrix[ix][i] == -1) {
                    index_neg_one[size_index_neg_one] = ix;
                    ++size_index_neg_one;
                }     
            }
            //Populate -1 indexes with max
            for (int row = 0; row < size_index_neg_one; ++row) {
                matrix[index_neg_one[row]][i] = max;
            }
        }

        return matrix;
    }
}
