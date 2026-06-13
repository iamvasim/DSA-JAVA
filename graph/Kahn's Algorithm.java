/*
Topological Sort

Question Link:
https://www.geeksforgeeks.org/problems/topological-sort/1

Optimal (Kahn's Algorithm - BFS):

1. Calculate indegree of every node.
2. Push all nodes having indegree 0 into queue.
3. Remove node from queue.
4. Add it to answer.
5. Reduce indegree of its neighbours.
6. If neighbour indegree becomes 0, push it into queue.

Time Complexity: O(V + E)
Space Complexity: O(V)
*/

class Solution {

    public ArrayList<Integer> topoSort(int V, int[][] edges) {

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

        ArrayList<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {

            int node = queue.poll();

            ans.add(node);

            for (int neighbour : adj.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return ans;
    }
}
