import java.util.*;

class UniqueSubstringFinder {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        UniqueSubstringFinder finder = new UniqueSubstringFinder();
        String s = "abcabcbb";
        System.out.println("Longest substring length: " + finder.lengthOfLongestSubstring(s));
    }
}
