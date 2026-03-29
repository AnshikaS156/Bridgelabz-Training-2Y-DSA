import java.util.*;

class SlidingWindowMaximum {

    static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove out of window indices
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }

            // Remove smaller elements
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offer(i);

            // Store result
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int[] res = maxSlidingWindow(nums, k);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}