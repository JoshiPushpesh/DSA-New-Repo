import java.util.*;

class Job {
    int start, end, profit;
    Job(int s, int e, int p) {
        start = s;
        end = e;
        profit = p;
    }
}

public class JobSchedulingMaxProfit {

    // Binary search to find latest job (before current job) that doesn't conflict
    private static int findLastNonConflict(List<Job> jobs, int index) {
        int low = 0, high = index - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs.get(mid).end <= jobs.get(index).start) {
                if (jobs.get(mid + 1).end <= jobs.get(index).start)
                    low = mid + 1;
                else
                    return mid;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<Job> jobs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }

        // Sort jobs by end time
        jobs.sort((a, b) -> a.end - b.end);

        int[] dp = new int[n];
        dp[0] = jobs.get(0).profit;

        for (int i = 1; i < n; i++) {
            int inclProfit = jobs.get(i).profit;
            int l = findLastNonConflict(jobs, i);
            if (l != -1) inclProfit += dp[l];

            dp[i] = Math.max(inclProfit, dp[i - 1]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] startTime = {1, 2, 3, 4, 6};
        int[] endTime   = {3, 5, 10, 6, 9};
        int[] profit    = {20, 20, 100, 70, 60};

        int result = jobScheduling(startTime, endTime, profit);
        System.out.println("Maximum profit: " + result);
    }
}
