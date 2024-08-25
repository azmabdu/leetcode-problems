package problems.graphs.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IslandPerimeter {
    public static Set<List<Integer>> visited;

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };

        int perimeter = islandPerimeter(grid);
        System.out.println(perimeter);  // Should output 16

        int perimeterOptimal = islandPerimeterOptimal(grid);
        System.out.println(perimeterOptimal);
    }

    public static int islandPerimeter(int[][] grid) {
        visited = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // Start DFS from the first land cell found
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    public static int dfs(int[][] grid, int i, int j) {
        // Check boundary conditions and water cells
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0) {
            return 1;
        }

        // Check if the cell has already been visited
        if (visited.contains(List.of(i, j))) {
            return 0;
        }

        // Mark the cell as visited
        visited.add(List.of(i, j));

        // Start calculating the perimeter  
        int perimeter = 0;
        perimeter += dfs(grid, i, j + 1); // Right
        perimeter += dfs(grid, i + 1, j); // Down
        perimeter += dfs(grid, i, j - 1); // Left
        perimeter += dfs(grid, i - 1, j); // Up

        return perimeter;
    }

    public static int islandPerimeterOptimal(int[][] grid) {
        // Initialize counters for the number of land cells (islands) and neighboring land cells (neighbours)
        int islands = 0;
        int neighbours = 0;

        // Iterate over each cell in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // Check if the current cell is land (represented by 1)
                if (grid[i][j] == 1) {
                    // Increment the count of land cells
                    islands += 1;

                    // Check the cell directly above the current one
                    // If it's also land, there's a shared edge between the two cells
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        neighbours += 1;
                    }

                    // Check the cell directly to the left of the current one
                    // If it's also land, there's a shared edge between the two cells
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        neighbours += 1;
                    }
                }
            }
        }

        // Calculate the perimeter:
        // - Each land cell contributes 4 to the perimeter.
        // - Each pair of neighboring land cells reduces the perimeter by 2 (since they share an edge).
        return islands * 4 - neighbours * 2;
    }
}