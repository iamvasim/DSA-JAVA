/*
547. Number of Provinces

Optimal (BFS):

Treat each city as a node in a graph.

1. Start BFS from every unvisited city.
2. Mark all directly and indirectly connected cities as visited.
3. Each BFS traversal represents one province.
4. Count the number of BFS traversals.

Time Complexity: O(n²)
Space Complexity: O(n)
*/

class Solution {

    void bfs(int start, int[][] isConnected, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(start);

        visited[start] = true;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int j = 0; j < isConnected.length; j++) {

                if (isConnected[node][j] == 1 && !visited[j]) {

                    visited[j] = true;
                    q.offer(j);
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int provinces = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                bfs(i, isConnected, visited);
                provinces++;
            }
        }

        return provinces;
    }
}




/*
547. Number of Provinces

Optimal (DFS):

1. Start DFS from every unvisited city.
2. Visit all directly and indirectly connected cities.
3. Each DFS traversal represents one province.
4. Count the number of DFS traversals.

Time Complexity: O(n²)
Space Complexity: O(n)
*/

class Solution {

    void dfs(int city, int[][] isConnected, boolean[] visited) {

        visited[city] = true;

        for (int neighbour = 0; neighbour < isConnected.length; neighbour++) {

            if (isConnected[city][neighbour] == 1
                    && !visited[neighbour]) {

                dfs(neighbour, isConnected, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int provinces = 0;

        for (int city = 0; city < n; city++) {

            if (!visited[city]) {

                dfs(city, isConnected, visited);
                provinces++;
            }
        }

        return provinces;
    }
}
