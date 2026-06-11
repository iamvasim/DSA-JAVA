/*
BFS of Graph



1. Start traversal from node 0.
2. Mark node 0 as visited and push it into the queue.
3. Remove a node from the queue.
4. Add it to the answer.
5. Visit all unvisited neighbours and push them into the queue.
6. Repeat until the queue becomes empty.

Time Complexity: O(V + E)
Space Complexity: O(V)
*/

class Solution {

    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {

        int v = adj.size();

        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[v];

        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {

            int node = q.poll();

            ans.add(node);

            for (int neighbour : adj.get(node)) {

                if (!visited[neighbour]) {

                    visited[neighbour] = true;
                    q.offer(neighbour);
                }
            }
        }

        return ans;
    }
}
