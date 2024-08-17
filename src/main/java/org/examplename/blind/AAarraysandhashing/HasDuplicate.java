package org.examplename.blind.AAarraysandhashing;

import java.util.HashSet;
import java.util.Set;

public class HasDuplicate {

    // 2024 08 17

    // Duplicate integer

    // https://neetcode.io/problems/duplicate-integer

    // Easy

    // Given an integer array nums, return true if any value
    // appears more than once in the array, otherwise return false.

    // Example 1:
    // Input: nums = [1, 2, 3, 3]
    // Output: true

    // Example 2:
    // Input: nums = [1, 2, 3, 4]
    // Output: false

    public static boolean hasDuplicateSimpleNotUniversal(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasDuplicateHashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (uniques.contains(nums[i])) {
                return true;
            }
            uniques.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {

        int[] myArr = {1, 2, 3, 4, 5};
        boolean result = hasDuplicate(myArr);
        System.out.println(result);

        int[] myArrDup = {1, 2, 3, 3, 4};
        boolean result2 = hasDuplicate(myArrDup);
        System.out.println(result2);

        int[] myArrDupToo = {1, 2, 3, 2};
        boolean result3 = hasDuplicate(myArrDupToo);
        System.out.println(result3);

    }

}
