import java.util.*;

class BracketValidator {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        BracketValidator validator = new BracketValidator();

        String test1 = "()[{}]";
        String test2 = "(]";

        System.out.println(test1 + " → " + validator.isValid(test1));  // true
        System.out.println(test2 + " → " + validator.isValid(test2));  // false
    }
}
