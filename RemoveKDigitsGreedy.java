import java.util.*;

public class RemoveKDigitsGreedy {

    public static String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";

        Deque<Character> stack = new ArrayDeque<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.pollLast();
                k--;
            }
            stack.addLast(digit);
        }

        // Remove remaining digits from the end
        while (k > 0) {
            stack.pollLast();
            k--;
        }

        // Build result without leading zeros
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;

        for (char c : stack) {
            if (leadingZero && c == '0') continue;
            leadingZero = false;
            sb.append(c);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3)); // 1219
        System.out.println(removeKdigits("10200", 1));   // 200
        System.out.println(removeKdigits("10", 2));      // 0
    }
}
