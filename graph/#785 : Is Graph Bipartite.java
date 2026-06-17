/*
LeetCode 785 : Is Graph Bipartite?

Question Link:
https://leetcode.com/problems/is-graph-bipartite/

Topic: Graphs, BFS, Graph Coloring

Optimal (BFS):

1. Assign one color to the starting node.
2. Color all its neighbours with the opposite color.
3. Continue BFS traversal.
4. If two adjacent nodes have the same color,
   the graph is not bipartite.
5. Since the graph may be disconnected,
   start BFS from every unvisited node.

Time Complexity: O(V + E)
Space Complexity: O(V)
*/

class Solution {

    boolean checkByBfs(int[][] graph,
                       int start,
                       int[] color,
                       int currentColor) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);

        color[start] = currentColor;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            for (int neighbour : graph[node]) {

                if (color[neighbour] == color[node]) {
                    return false;
                }

                if (color[neighbour] == -1) {

                    color[neighbour] = 1 - color[node];

                    queue.offer(neighbour);
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {

        int[] color = new int[graph.length];

        Arrays.fill(color, -1);

        for (int i = 0; i < graph.length; i++) {

            if (color[i] == -1) {

                if (!checkByBfs(graph, i, color, 1)) {
                    return false;
                }
            }
        }

        return true;
    }
}






/*
LeetCode 785 : Is Graph Bipartite?

Question Link:
https://leetcode.com/problems/is-graph-bipartite/

Topic: Graphs, DFS, Graph Coloring

Optimal (DFS):

1. Assign a color to the current node.
2. Assign the opposite color to all neighbours.
3. Recursively perform DFS.
4. If two adjacent nodes have the same color,
   the graph is not bipartite.
5. Since the graph may be disconnected,
   start DFS from every unvisited node.

Time Complexity: O(V + E)
Space Complexity: O(V)
*/

class Solution {

    boolean checkByDfs(int[][] graph,
                       int node,
                       int[] color,
                       int currentColor) {

        color[node] = currentColor;

        for (int neighbour : graph[node]) {

            if (color[neighbour] == color[node]) {
                return false;
            }

            if (color[neighbour] == -1) {

                if (!checkByDfs(graph,
                                neighbour,
                                color,
                                1 - currentColor)) {

                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {

        int[] color = new int[graph.length];

        Arrays.fill(color, -1);

        for (int i = 0; i < graph.length; i++) {

            if (color[i] == -1) {

                if (!checkByDfs(graph, i, color, 1)) {
                    return false;
                }
            }
        }

        return true;
    }
}
