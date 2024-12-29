package org.examplename.blind.AAarraysandhashing;

public class ProductsOfArrayExceptSelf {

    // https://neetcode.io/problems/products-of-array-discluding-self

    // Products of Array Except Self

    // Medium

    // Given an integer array nums, return an array output where
    // output[1] is the product of all the elements of nums except nums[i].

    // Each product is guaranteed to fit in a 32-bit integer.

    // Follow-up: Could you solve it in O(n) time without using the division operation?

    // Example 1:
    // Input: nums = [1,2,4,6]
    // Output: [48,24,12,6]

    // Example 2:
    // Input: nums = [-1,0,1,2,3]
    // Output: [0,-6,0,0,0,-]

    // Constraints:
    // * 1 <= nums.length <= 1000
    // * -20 <= nums[i] <= 20

    // Recommended Time & Space Complexity
    // You should aim for a solution as good or better than O(n) time
    // and O(n) space, where n is the size of the input array.

    // Hint 1
    // A brute-force solution would be to iterate through the array
    // with index i and compute the product of the array
    // except for that index element. This would be an O(n^2) solution.
    // Can you think of a better way?

    // Hint 2
    // Is there a way to avoid the repeated work?
    // Maybe we can store the results of the repeated work in an array.

    // Hint 3
    // We can use the prefix and suffix technique. First, we iterate from
    // left to right and store the prefix products for each index in a prefix array,
    // excluding the current index's number. Then, we iterate from right to left
    // and store the suffix products for each index in a suffix array,
    // also excluding the current index's number.
    // Can you figure out the solution from there?

    // Hint 4
    // We can use the stored prefix and suffix products to compute
    // the results array by iterating through the array
    // and simply multiplying the prefix and suffix products of each index.



}

class SolutionProductsOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {


        int[] integerArray = new int[0];
        return integerArray;
    }

    // * Time complexity: O(n^2)
    // * Space complexity: O(1) since the output array is excluded from space analysis.
    public int[] productExceptSelfBruteForce(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    prod *= nums[j];
                }
            }
            res[i] = prod;
        }
        return res;
    }

    // * Time complexity: O(n)
    // * Space complexity: O(1) since the output array is excluded from space analysis.
    public int[] productExceptSelfDivision(int[] nums) {
        int prod = 1, zeroCount = 0;
        for (int num : nums) {
            if (num != 0) {
                prod *= num;
            } else {
                zeroCount++;
            }
        }

        if (zeroCount > 1) {
            return new int[nums.length];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                res[i] = (nums[i] == 0) ? prod : 0;
            } else {
                res[i] = prod / nums[i];
            }
        }
        return res;
    }

    // * Time and Space Complexity: O(n)
    // * Space complexity: O(n)
    public int[] productExceptSelfPrefixAndSuffix(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] pref = new int[n];
        int[] suff = new int[n];

        pref[0] = 1;
        suff[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            pref[i] = nums[i - 1] * pref[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = nums[i + 1] * suff[i + 1];
        }
        for (int i = 0; i < n; i++) {
            res[i] = pref[i] * suff[i];
        }
        return res;
    }

    // * Time complexity: O(n)
    // * Space complexity: O(1) since the output array is excluded from space analysis.
    public int[] productExceptSelfPrefixAndSuffixOptimal(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }

}
