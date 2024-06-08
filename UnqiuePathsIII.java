//Date: 6/6/2024
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Unique Paths III

/*
You are given an m x n integer array grid where grid[i][j] could be:

1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, 
that walk over every non-obstacle square exactly once.

Example 1:
Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

Example 2:
Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)

Example 3:
Input: grid = [[0,1],[2,0]]
Output: 0
Explanation: There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 20
1 <= m * n <= 20
-1 <= grid[i][j] <= 2
There is exactly one starting cell and one ending cell.
*/

public class UniquePathsIII {

    //Method returns the number of unique paths
    public int uniquePathsIII(int[][] grid) {
        NumberPaths paths = new NumberPaths();
        paths.unique_paths = 0;
        Coordinates current_location = findOne(grid);
        uniquePathsIII(grid, paths, current_location);
        return paths.unique_paths;
    }

    //Method cauclates totale successful paths
    private void uniquePathsIII(int[][] grid, NumberPaths paths, Coordinates curr_loc) {
        //Change current location to -3 to denote visited location
        grid[curr_loc.row][curr_loc.column] = -3;
        //List to store available adjacent coordinates
        List<Coordinates> adjacentZeros = findAdjacentZeros(grid, curr_loc);
        //No available locations to go to
        if (adjacentZeros.isEmpty()) {
            if (!walkOverSquares(grid) && isAdjacentToTwo(grid, curr_loc))
                paths.unique_paths += 1;
            grid[curr_loc.row][curr_loc.column] = 0;
            return;
        }
        //More locations to go to
        else {
            //Iterate through the found adjacent coordinates to go to
            for (Coordinates adjCoord : adjacentZeros) {
                int[][] copyGrid = generateCopy(grid);
                uniquePathsIII(copyGrid, paths, adjCoord);
            }
        }
    }

    //Method generates a copy of a grid
    public static int[][] generateCopy(int[][] grid) {
        int[][] copy = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        return copy;
    }

    //Method returns all the adjacent 0s next to the coordinates
    private List<Coordinates> findAdjacentZeros(int[][] grid, Coordinates current) {
        List<Coordinates> adjacentZeros = new ArrayList<>();
        //Offsets for row (up, right, down, left)
        int[] dx = {0, 1, 0, -1};
        //Offsets for column (up, right, down, left)
        int[] dy = {-1, 0, 1, 0};

        //Iterate over each direction (up, right, down, left)
        for (int i = 0; i < 4; i++) {
            int newRow = current.row + dx[i];
            int newColumn = current.column + dy[i];
            //Check if the new coordinates are within the grid bounds and the value is 0
            if (newRow >= 0 && newRow < grid.length && newColumn >= 0 && newColumn < grid[0].length &&
                grid[newRow][newColumn] == 0) {
                //If the conditions are met, add the coordinates to the list
                adjacentZeros.add(new Coordinates(newRow, newColumn));
            }
        }
        return adjacentZeros;
    }

    //Method returns true if there is an adjacent ending square
    private boolean isAdjacentToTwo(int[][] grid, Coordinates current) {
        //Offsets for row (up, right, down, left)
        int[] dx = {0, 1, 0, -1};
        //Offsets for column (up, right, down, left)
        int[] dy = {-1, 0, 1, 0};

        //Iterate over each direction (up, right, down, left)
        for (int i = 0; i < 4; i++) {
            int newRow = current.row + dx[i];
            int newColumn = current.column + dy[i];

            //Check if the new coordinates are within the grid bounds and the value is 2
            if (newRow >= 0 && newRow < grid.length && newColumn >= 0 && newColumn < grid[0].length &&
                grid[newRow][newColumn] == 2) {
                return true;
            }
        }
        return false;
    }

    //Method returns true if there are still squares available to walk over, otherwise false
    private boolean walkOverSquares(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    //Method returns where the starting coordinate is
    private Coordinates findOne(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 1) {
                    return new Coordinates(row, column);
                }
            }
        }
        return null;
    }

    //Class to store a coordinate
    class Coordinates {
        int row;
        int column;

        Coordinates(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    //Class to store the number of unique paths
    class NumberPaths {
        int unique_paths;
    }
}