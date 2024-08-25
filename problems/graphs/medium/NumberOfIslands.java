package problems.graphs.medium;

import java.util.*;

public class NumberOfIslands {
    // Set to track visited cells during BFS
    private static final Set<List<Integer>> visited = new HashSet<>();

    // Deque (double-ended queue) to manage the frontier of the BFS
    private static final Deque<List<Integer>> deque = new ArrayDeque<>();

    // Define the four possible directions to move in the grid (right, down, left, up)
    private static final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        // Define a sample grid representing land ('1') and water ('0')
        char[][] grid = new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0', '0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        // Calculate the number of islands in the grid
        int numberOfIslands = numIslands(grid);
        System.out.println(numberOfIslands);  // Output the number of islands
    }

    // Method to count the number of islands in the grid
    public static int numIslands(char[][] grid) {
        // Handle null input
        if (grid == null) {
            return 0;
        }

        int islands = 0;  // Counter for the number of islands

        int rows = grid.length;
        int columns = grid[0].length;

        // Iterate over each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // If the cell is land ('1'), perform DFS to mark the entire island
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands += 1;  // Increment the island count after DFS
                }

                // BFS approach (alternative to DFS)
                // Uncomment the following block and comment the DFS block above if you prefer BFS
                /*
                if (grid[i][j] == '1' && !visited.contains(List.of(i, j))) {
                    bfs(grid, i, j);
                    islands += 1;
                }
                */
            }
        }

        return islands;  // Return the total number of islands found
    }

    // DFS method to traverse and mark all cells in the current island
    public static void dfs(char[][] grid, int i, int j) {
        // Base case: out of bounds or not land
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0';  // Mark the cell as visited by converting it to water ('0')

        // Recursively visit all four possible neighbors
        dfs(grid, i, j + 1);  // Right
        dfs(grid, i, j - 1);  // Left
        dfs(grid, i + 1, j);  // Down
        dfs(grid, i - 1, j);  // Up
    }

    // BFS method to traverse and mark all cells in the current island
    public static void bfs(char[][] grid, int i, int j) {
        visited.add(List.of(i, j));  // Mark the starting cell as visited
        deque.addFirst(List.of(i, j));  // Add the starting cell to the deque

        // Continue BFS until all connected land cells are visited
        while (!deque.isEmpty()) {
            List<Integer> coords = deque.pollFirst();  // Get the current cell
            int x = coords.get(0);
            int y = coords.get(1);

            // Iterate over the four possible directions (right, down, left, up)
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                // Check if the new position is within bounds, is land, and hasn't been visited
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length
                    && grid[newX][newY] == '1' && !visited.contains(List.of(newX, newY))) {
                    visited.add(List.of(newX, newY));  // Mark the new cell as visited
                    deque.addLast(List.of(newX, newY));  // Add the new cell to the deque for further exploration
                }
            }
        }
    }
}