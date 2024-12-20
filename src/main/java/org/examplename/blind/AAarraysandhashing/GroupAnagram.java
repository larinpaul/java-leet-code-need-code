package org.examplename.blind.AAarraysandhashing;

import java.util.*;

public class GroupAnagram {

    // Group Anagrams

    // Medium

    // Given an array of strings strs, group all anagrams together
    // into sublists. You may return the output in any order.

    // An anagram is a string that contains the exact same characters
    // as another string, but the order of the characters can be different.

    // Example 1:
    // Input: strs = ["act","pots","tops","cat","stop","hat"]
    // Output: [["hat"],["act","cat"],["stop","pots","tops"]]

    // Example 2:
    // Input: strs = ["x"]
    // Output: [["x"]]

    // Example 3:
    // Input: strs = [""]
    // Output: [[""]]

    // Constraints:
    // * 1 <= strs.length <= 1000.
    // * 0 <= strs[i].length <= 100
    // * strs[i] is made up of lowercase English letters.

    // Recommended Time & Space Complexity
    // You should aim for a solution with O(m * n) time and O(m) space,
    // where m is the number of strings and n is the length of the longest string.

    // Hint 1
    // A naive solution would be to sort each string and group them together
    // using a hash map. This would be an O(m * nlogn) solution.
    // Though this solution is acceptable,
    // can you think of a better way without sorting the strings?

    // Hint 2
    // By the definition of an anagram, we only care about the frequency
    // of each character in a string. How is this helpful
    // in solving the problem?

    // Hint 3
    // We can simply use an array of size O(26),
    // since the character set is a through z (26 continuous characters),
    // to count the frequency of each character in a string.
    // Then, we can use this array as the key
    // in the hash map to group the strings


    public static void main(String[] args) {
        GroupAnagramSolution solution = new GroupAnagramSolution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagamsHashMap(strs);
        System.out.println(result);
    }

}

class GroupAnagramSolution {

    public List<List<String>> groupAnagram(String[] strs) {

        return List.of(List.of("Hi1", "Hi2"));
    }

    // 1. Sorting solution
    public List<List<String>> groupAnagramSort(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);
            res.putIfAbsent(sortedS, new ArrayList<>());
            res.get(sortedS).add(s);
        }
        return new ArrayList<>(res.values());
    }
    // Time & Space Complexity
    // * Time complexity: O(m * n log n)
    // * Space complexity: O(m * n)
    // Where m is the number of strings and n is the length of the longest string.

    // 2. Hash table
    public List<List<String>> groupAnagamsHashMap(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }

    public List<List<String>> groupAnagamsHashMapCharFrequency(String[] strs) {
        Map<CharFrequency, List<String>> res = new HashMap<>();
        for (String s : strs) {
            CharFrequency frequency = new CharFrequency();
            for (char c : s.toCharArray()) {
                frequency.count[c - 'a']++;
            }
            res.putIfAbsent(frequency, new ArrayList<>());
            res.get(frequency).add(s);
        }
        return new ArrayList<>(res.values());
    }

    class CharFrequency {
        int[] count = new int[26];

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CharFrequency that = (CharFrequency) o;
            return Arrays.equals(count, that.count);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(count);
        }
    }


}





