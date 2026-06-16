/*
Directed Graph Cycle

Question Link:
https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

Topic: Graphs, Topological Sort, Kahn's Algorithm

Optimal (BFS - Kahn's Algorithm):

1. Build the adjacency list.
2. Compute indegree of every node.
3. Push all nodes having indegree 0 into the queue.
4. Perform Topological Sort using BFS.
5. Count the number of processed nodes.
6. If processed nodes == V, no cycle exists.
7. Otherwise, a cycle is present.

Time Complexity: O(V + E)
Space Complexity: O(V)
*/

class Solution {

    public boolean isCyclic(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        int[] indegree = new int[V];

        for (int u = 0; u < V; u++) {

            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            count++;

            for (int neighbour : adj.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return count != V;
    }
}
