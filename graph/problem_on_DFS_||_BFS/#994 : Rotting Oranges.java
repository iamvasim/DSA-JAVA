/*
Question Link:
https://leetcode.com/problems/rotting-oranges/

Topic: Graphs, BFS, Multi-Source BFS

Optimal (Multi-Source BFS):

1. Push all rotten oranges into the queue.
2. Count the number of fresh oranges.
3. Perform BFS level by level.
4. Every level represents one minute.
5. Convert adjacent fresh oranges into rotten oranges.
6. If all fresh oranges become rotten, return time taken.
7. Otherwise, return -1.

Time Complexity: O(m × n)
Space Complexity: O(m × n)
*/

class Solution {

    class Pair {

        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();

        int freshCount = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                }
                else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        int minutes = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                Pair current = queue.poll();

                for (int[] dir : directions) {

                    int newRow = current.x + dir[0];
                    int newCol = current.y + dir[1];

                    if (newRow >= 0 && newRow < m
                            && newCol >= 0 && newCol < n
                            && grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;

                        queue.offer(new Pair(newRow, newCol));

                        freshCount--;
                    }
                }
            }

            minutes++;
        }

        return freshCount == 0 ? minutes - 1 : -1;
    }
}
