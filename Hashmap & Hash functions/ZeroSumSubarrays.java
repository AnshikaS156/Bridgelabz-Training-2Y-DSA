import java.util.*;

class ZeroSumSubarrays {

    static void findSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;

        // Important: handle sum = 0 case
        map.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                List<Integer> list = map.get(sum);
                for (int start : list) {
                    System.out.println("Subarray: " + (start + 1) + " to " + i);
                }
            }

            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 2, -6, 4};
        findSubarrays(arr);
    }
}