package org.examplename.blind.AAarraysandhashing;

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

