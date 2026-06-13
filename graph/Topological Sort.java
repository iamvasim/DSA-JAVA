/*
Topological Sort

Question Link:
https://www.geeksforgeeks.org/problems/topological-sort/1

Optimal (DFS):

1. Perform DFS on every unvisited node.
2. After visiting all neighbours of a node,
   push it into the stack.
3. Pop all elements from the stack to get
   the topological ordering.

Time Complexity: O(V + E)
Space Complexity: O(V)
*/

class Solution {

    void dfs(ArrayList<ArrayList<Integer>> adj,
             int node,
             boolean[] visited,
             Stack<Integer> stack) {

        visited[node] = true;

        for (int neighbour : adj.get(node)) {

            if (!visited[neighbour]) {
                dfs(adj, neighbour, visited, stack);
            }
        }

        stack.push(node);
    }

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

        boolean[] visited = new boolean[V];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {
                dfs(adj, i, visited, stack);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }

        return ans;
    }
}
