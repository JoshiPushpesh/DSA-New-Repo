import java.util.*;

public class LargestNumberForm {
    
    public static String largestNumber(int[] nums) {
        // Convert int[] to String[]
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sort based on custom comparator
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // If largest is "0", return "0"
        if (strNums[0].equals("0")) return "0";

        // Build the result
        StringBuilder sb = new StringBuilder();
        for (String s : strNums) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};

        String result = largestNumber(nums);
        System.out.println("Largest formed number: " + result);
    }
}
