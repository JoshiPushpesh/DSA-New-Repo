import java.util.*;

class TemperatureAnalyzerX {

    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // store indexes of unresolved days

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
                int prev = stack.pop();
                answer[prev] = i - prev;  // how many days until warmer temp
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        TemperatureAnalyzerX analyzer = new TemperatureAnalyzerX();
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("Days until warmer temperature: " + Arrays.toString(analyzer.dailyTemperatures(temps)));
    }
}
