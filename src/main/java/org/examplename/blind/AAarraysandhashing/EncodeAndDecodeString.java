package org.examplename.blind.AAarraysandhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeString {

    // https://neetcode.io/problems/string-encode-and-decode

    // Encode and Decode Strings

    // Medium

    // Design an algorithm to encode a list of strings to a single string.
    // The encoded string is then decoded back to the original list of strings.

    // Please implement encode and decode

    // Example 1:
    // Input: ["neet","code","love","you"]
    // Output: ["neet","code","love","you"]

    // Example 2:
    // Input: ["we","say",":","yes"]
    // Output: ["we","say",":","yes"]

    // Constraints:
    // * 0 <= strs.length < 100
    // * 0 <= strs[i].length < 200
    // * strs[i] contains only UTF-8 characters.

    // Recommended Time & Space Complexity
    // You should aim for a solution with O(m) time and O(1) space
    // for each encode() and decode() call,
    // where m is th sum of lengths of all the strings.

    // Hint 1
    // A naive solution would be to use a non-ascii character as a delimiter.
    // Can you think of a better way?

    // Hint 2
    // Try to encode and decode the strings using a smart approach
    // based on the lengths of each string.
    // How can you differentiate between the lengths
    // and any numbers that might be present in the strings?

    // Hint 3
    // We can use an encoding approach where we start with a number
    // representing the length of the string, followed by a separator
    // character (let's use # for simplicity), and then the string itself.
    // To decode, we read the number until we reach a #.
    // then use that number
    // to read the specified number of characters as the string.

    public static void main(String[] args) {
        SoltuionEcodeAndDecodeStrings s = new SoltuionEcodeAndDecodeStrings();
        System.out.println(s.decodeOptimal("Hi"));
    }

}

class SoltuionEcodeAndDecodeStrings  {

    public String encodeN(List<String> strs) {
        if (strs.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();
        for (String str : strs) {
            sizes.add(str.length());
        }
        for (int size : sizes) {
            res.append(size).append(',');
        }
        res.append('#');
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    public List<String> decodeN(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        while (str.charAt(i) != '#') {
            StringBuilder cur = new StringBuilder();
            while (str.charAt(i) != ',') {
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }
        i++;
        for (int sz : sizes) {
            res.add(str.substring(i, i + sz));
            i += sz;
        }
        return res;
    }

    public String encodeOptimal(List<String> strs) {

        return "Hello Optimal";
    }

    public List<String> decodeOptimal(String str) {

        return Arrays.asList("You can do it! :)", "Yeah!");
    }




}
