/*
LeetCode 210 : Course Schedule II

Question Link:
https://leetcode.com/problems/course-schedule-ii/

Topic: Graphs, Topological Sort, Kahn's Algorithm

Optimal (BFS - Kahn's Algorithm):

1. Create the adjacency list.
2. Compute indegree of every course.
3. Push all courses having indegree 0 into the queue.
4. Perform Topological Sort using BFS.
5. Store the order in the answer array.
6. If all courses are processed, return the ordering.
7. Otherwise, a cycle exists, so return an empty array.

Time Complexity: O(V + E)
Space Complexity: O(V)
*/

class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {

            int course = edge[0];
            int prerequisite = edge[1];

            adj.get(prerequisite).add(course);
        }

        int[] indegree = new int[numCourses];

        for (int u = 0; u < numCourses; u++) {

            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] ans = new int[numCourses];

        int idx = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            ans[idx++] = node;

            for (int neighbour : adj.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return idx == numCourses ? ans : new int[0];
    }
}
