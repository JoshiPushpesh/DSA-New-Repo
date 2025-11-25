import java.util.*;

class PalindromePartitionerX {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (isPalindrome(s, start, end - 1)) {
                current.add(s.substring(start, end));
                backtrack(s, end, current, result);
                current.remove(current.size() - 1); // backtrack
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitionerX partitioner = new PalindromePartitionerX();
        String s = "aab";
        List<List<String>> result = partitioner.partition(s);
        System.out.println("Palindrome partitions of \"" + s + "\":");
        for (List<String> part : result) {
            System.out.println(part);
        }
    }
}
