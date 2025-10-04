import java.util.*;

class CoursePlanner {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int completed = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            completed++;

            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) queue.offer(next);
            }
        }

        return completed == numCourses;
    }

    // 🔹 Demo
    public static void main(String[] args) {
        CoursePlanner solver = new CoursePlanner();
        int[][] prerequisites1 = {{1, 0}};
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        
        System.out.println(solver.canFinish(2, prerequisites1)); // Output: true
        System.out.println(solver.canFinish(2, prerequisites2)); // Output: false
    }
}
