package org.examplename.blind.AAarraysandhashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {


    // https://neetcode.io/problems/is-anagram

    // Valid Anagram
    // Easy

    // Given two strings s and t, return true if the two strings are anagrams of each other,
    // otherwise return false.

    // An anagram is a string that contains the exact same characters as another string,
    // but the order of the characters can be different.

    // Example 1:
    // Input: s = "racecar", t = "carrace"
    // Output: true

    // Example 2:
    // Input: s = "jar", t = "jam"
    // Output: false

    // Constraints:
    // * s and t consist of lowercase English letters.

    // Recommended Time & Space Complexity
    // You should aim for a solution with O(n + m) time and O(1) space,
    // where n is the length of the string s and m is the length of the string t.

    // Hint 1
    // A brute force solution would be to sort the given strings
    // and check for their equality.
    // This would be an O(nlogn + nlogm) solution.
    // Though this solution is acceptable,
    // can you think of a better way without sorting the given strings?

    // Hint 2
    // By the definition of the anagram, we can rearrange the characters.
    // Does the order of the characters matter in both the strings?
    // Then what matters?

    // Hint 3
    // We can just consider maintaining the frequency of each character.
    // We can do this by having two separate hash tables for two strings.
    // Then, we can check whether the frequency of each character in string s
    // is equal to that in string t and vice versa.

    public static void main(String[] args) {
        System.out.println("Hi");
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("racecar", "carrace")); // true
        System.out.println(solution.isAnagram("carrace", "ddd")); // false
        System.out.println("Optimized solution:");
        LessOptimizedSolution lessOptimizedSolution = new LessOptimizedSolution();
        System.out.println(lessOptimizedSolution.isAnagram("racecar", "carrace")); // true
        System.out.println(lessOptimizedSolution.isAnagram("carrace", "ddd")); // false
        MostOptimizedSolution mostOptimizedSolution = new MostOptimizedSolution();
        System.out.println(mostOptimizedSolution.isAnagram("racecar", "carrace")); // true
        System.out.println(mostOptimizedSolution.isAnagram("carrace", "ddd")); // false
    }

}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> hm = new HashMap<>();

        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1); // getOrDefault is a method in Java's Map interface that returns the value associated with a given key, or a default value if the key is not present in the map (provided as a second argument)
        }

        for (char c : t.toCharArray()) {
            if (!hm.containsKey(c)) {
                return false;
            }
            hm.put(c, hm.get(c) - 1);
        }

        for (int value : hm.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
}

class LessOptimizedSolution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        return Arrays.equals(sSort, tSort);
    }
}

class MostOptimizedSolution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countS.equals(countT);
    }
}
