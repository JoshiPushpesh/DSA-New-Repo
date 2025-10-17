import java.util.*;

class UniqueSubstringHunter {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If character already exists in window, move left pointer
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            // Update last index of the character
            map.put(ch, right);

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        UniqueSubstringHunter hunter = new UniqueSubstringHunter();
        String s = "pwwkew";
        System.out.println("Longest substring length: " + hunter.lengthOfLongestSubstring(s));
    }
}
