import java.util.*;

class AlienDictionarySolver {
    public String alienOrder(String[] words) {
        // Step 1: Build graph
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return ""; // invalid order
            }

            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        // Step 2: Topological Sort (Kahn’s Algorithm)
        Queue<Character> queue = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) queue.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char next : graph.get(c)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) queue.add(next);
            }
        }

        return sb.length() == indegree.size() ? sb.toString() : "";
    }

    // 🔹 Demo main function
    public static void main(String[] args) {
        AlienDictionarySolver solver = new AlienDictionarySolver();
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println(solver.alienOrder(words)); // Output: "wertf"
    }
}
