import java.util.*;

class WordLadderSolver {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return steps;

                char[] arr = word.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String next = new String(arr);
                        if (dict.contains(next)) {
                            queue.add(next);
                            dict.remove(next);
                        }
                    }
                    arr[j] = original;
                }
            }
            steps++;
        }
        return 0;
    }

    // 🔹 Demo main function
    public static void main(String[] args) {
        WordLadderSolver solver = new WordLadderSolver();
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(solver.ladderLength("hit", "cog", wordList)); // Output: 5
    }
}
