import java.util.*;

class WordLadderExplorer {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return level;

                char[] arr = word.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        arr[j] = c;
                        String newWord = new String(arr);
                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord); // Avoid revisiting
                        }
                    }
                    arr[j] = original;
                }
            }
            level++;
        }
        return 0;
    }

    // 🔹 Demo
    public static void main(String[] args) {
        WordLadderExplorer solver = new WordLadderExplorer();
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(solver.ladderLength("hit", "cog", wordList)); // Output: 5
    }
}
