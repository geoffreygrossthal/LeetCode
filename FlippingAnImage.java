//Date: 5/23/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Flipping An Image

/*
Given an n x n binary matrix image, flip the image horizontally, then invert it, and 
return the resulting image.
To flip an image horizontally means that each row of the image is reversed.
For example, flipping [1,1,0] horizontally results in [0,1,1].
To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
For example, inverting [0,1,1] results in [1,0,0].
 
Example 1:
Input: image = [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

Example 2:
Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 
Constraints:
n == image.length
n == image[i].length
1 <= n <= 20
images[i][j] is either 0 or 1.
*/

public class FlippingAnImage {

    //Method returns a 2d array flipped and inverted
    public int[][] flipAndInvertImage(int[][] image) {

        //n x n matrix, length = n
        int length = image.length;

        int[][] flip_inverted_image = new int[length][length];
        
        for (int row = 0; row < length; ++row) {
            for (int column = 0; column < length; ++column) {
                if (image[row][column] == 0)
                    flip_inverted_image[row][(length - 1) - column] = 1;
                else
                    flip_inverted_image[row][(length - 1) - column] = 0;
            }
        }

        return flip_inverted_image;
    }
}