/*
DFS of Graph

Optimal (Recursive DFS):

1. Start DFS from node 0.
2. Mark the current node as visited.
3. Add it to the answer.
4. Recursively visit all unvisited neighbours.
5. Continue until all reachable nodes are visited.

Time Complexity: O(V + E)
Space Complexity: O(V)
*/

class Solution {

    ArrayList<Integer> ans;

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {

        ans = new ArrayList<>();

        boolean[] visited = new boolean[adj.size()];

        dfsTraversal(0, adj, visited);

        return ans;
    }

    private void dfsTraversal(int node,
                              ArrayList<ArrayList<Integer>> adj,
                              boolean[] visited) {

        visited[node] = true;

        ans.add(node);

        for (int neighbour : adj.get(node)) {

            if (!visited[neighbour]) {
                dfsTraversal(neighbour, adj, visited);
            }
        }
    }  
}



/*
DFS of Graph

Optimal (Iterative DFS):

1. Start DFS from node 0.
2. Push node 0 into the stack.
3. Pop a node from the stack.
4. If not visited, mark it visited and add it to the answer.
5. Push neighbours in reverse order to maintain adjacency list order.
6. Repeat until the stack becomes empty.

Time Complexity: O(V + E)
Space Complexity: O(V)
*/

class Solution {

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {

        int v = adj.size();

        boolean[] visited = new boolean[v];

        Stack<Integer> stack = new Stack<>();

        ArrayList<Integer> ans = new ArrayList<>();

        stack.push(0);

        while (!stack.isEmpty()) {

            int node = stack.pop();

            if (visited[node]) {
                continue;
            }

            visited[node] = true;

            ans.add(node);

            for (int i = adj.get(node).size() - 1; i >= 0; i--) {

                int neighbour = adj.get(node).get(i);

                if (!visited[neighbour]) {
                    stack.push(neighbour);
                }
            }
        }

        return ans;
    }
}


