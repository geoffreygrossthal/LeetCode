//Date: 6/12/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem IslandPerimeter

/*
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one 
island (i.e., one or more connected land cells).
The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side 
length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example 1:
Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.

Example 2:
Input: grid = [[1]]
Output: 4

Example 3:
Input: grid = [[1,0]]
Output: 4
 
Constraints:
row == grid.length
col == grid[i].length
1 <= row, col <= 100
grid[i][j] is 0 or 1.
There is exactly one island in grid.
*/


public class IslandPerimeter {

    //Method calculates the perimeter of an island
    public int islandPerimeter(int[][] grid) {
        int y = 0;
        int x = 0;
        boolean found = false;
        int numRows = grid.length;
        int numCols = grid[0].length;
    
        while (y < numRows && !found) {
            x = 0;
            while (x < numCols && !found) {
                if (grid[y][x] == 1)
                    found = true;
                x++;
            }
            y++;
        }
    
        if (!found)
            return 0;
    
        return islandPerimeterRec(grid, y - 1, x - 1);
    }

    //Method is a recursive function to help calculate perimeter
    public int islandPerimeterRec(int[][] grid, int y, int x) {
        if (y < 0 || x < 0 || y > grid.length-1 || x > grid[y].length-1 || grid[y][x] == -1 || grid[y][x] == 0)
            return 0;
        else {
            //Mark grid to negative -1 to denote visited coordinate
            grid[y][x] = -1;
            int total = 0;
            total += countEdgesAround(y, x, grid);
            total += islandPerimeterRec(grid, y - 1, x);
            total += islandPerimeterRec(grid, y + 1, x);
            total += islandPerimeterRec(grid, y, x - 1);
            total += islandPerimeterRec(grid, y, x + 1);
            return total;
        }
    }

    //Method returns the number edges surrounding a coordinate
    private int countEdgesAround(int y, int x, int[][] grid) {
        int count = 0;
        int numRows = grid.length;
        int numCols = grid[0].length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
    
        for (int i = 0; i < dx.length; i++) {
            int newRow = y + dy[i];
            int newCol = x + dx[i];
            //Check if the new coordinates are within the grid boundaries
            if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols) {
                //If the neighboring cell is water (0), increment count
                if (grid[newRow][newCol] == 0) {
                    count++;
                }
            } else {
                //If the neighboring cell is out of grid bounds, or it's land (1), increment count
                count++;
            }
        }
    
        return count;
    }
}