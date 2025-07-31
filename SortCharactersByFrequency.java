import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Create a max-heap based on frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) ->
            freqMap.get(b) - freqMap.get(a)
        );

        // Step 3: Add all characters to the heap
        maxHeap.addAll(freqMap.keySet());

        // Step 4: Build the result string
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char ch = maxHeap.remove();
            int freq = freqMap.get(ch);
            for (int i = 0; i < freq; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    // Driver Code
    public static void main(String[] args) {
        SortCharactersByFrequency obj = new SortCharactersByFrequency();
        String s = "tree";
        System.out.println(obj.frequencySort(s));  // Output: "eetr"
    }
}
