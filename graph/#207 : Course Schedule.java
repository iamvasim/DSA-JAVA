/*
LeetCode 207 : Course Schedule

Question Link:
https://leetcode.com/problems/course-schedule/

Topic: Graphs, Topological Sort, Kahn's Algorithm

Optimal (BFS - Kahn's Algorithm):

1. Create the adjacency list.
2. Compute indegree of every course.
3. Push all courses having indegree 0 into the queue.
4. Perform Topological Sort using BFS.
5. Count the number of processed courses.
6. If count == numCourses, all courses can be completed.
7. Otherwise, a cycle exists and it is impossible to finish all courses.

Time Complexity: O(V + E)
Space Complexity: O(V)
*/

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

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

        return count == numCourses;
    }
}
