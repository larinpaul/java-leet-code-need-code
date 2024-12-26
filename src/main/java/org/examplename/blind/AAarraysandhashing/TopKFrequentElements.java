package org.examplename.blind.AAarraysandhashing;

import java.util.*;

public class TopKFrequentElements {

    // https://neetcode.io/problems/top-k-elements-in-list

    // Top K Frequent Elements

    // Medium

    // Given an integer array nums and an integer k,
    // return the k most frequent elements within the array.

    // The test cases are generated such that the answer is always unique.

    // You may return the output in any order.

    // Example 1:
    // Input: nums = [1,2,2,3,3,3], k = 2
    // Output: [2, 3]

    // Example 2:
    // Input: nums = [7,7], k = 1
    // Output: [7]

    // Constraints:
    // * 1 <= nums.length <= 10^4
    // * -1000 <= nums[i] <= 1000
    // * 1 <= k <= number of distinct elements in nums.

    // Recommended Time & Space Complexity
    // You should aim for a solution with O(n) time and O(n) space,
    // where n is the size of the input array.

    // Hint 1
    // A naive soution would be to count the frequency of each number
    // and then sort the array based on each element's frequency.
    // After that, we would select the top k frequent elements.
    // This would be an O(nlogn) solution.
    // Though this solution is acceptable,
    // can you think of a better way?

    // Hint 2
    // Can you think of an algorithm which involves grouping numbers
    // based on their frequency?

    // Hint 3
    // Use the bucket sort algorithm to create n buckets,
    // grouping numbers based on their frequencies from 1 to n.
    // Then, pick the top k numbers from the buckets,
    // starting from n down to 1.


}

class SolutionTopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

        return new int[1];
    }

    public int[] topKFrequentWithSorting(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }
        arr.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }

    public int[] topKFrequentWithSortingHep(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }
        return res;
    }

}


