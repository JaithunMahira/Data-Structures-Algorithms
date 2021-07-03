/* Leetcode Link : https://leetcode.com/problems/longest-substring-without-repeating-characters/

Question : 
Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int len = s.length();
        
        int result = 0;
        boolean[] count = new boolean[128];
        
        while(end < len) {
            if(!count[s.charAt(end)]){
                count[s.charAt(end)] = true;
            } else {
                result = Math.max(result, end - start);
                
                while(start <= end && s.charAt(end) != s.charAt(start)) {
                    count[s.charAt(start)] = false;
                    start++;
                }
                start++;
            }
            end++;
        }
        
        return Math.max(result, end - start);
    }
}

/*
Time complexity : O(n)
Space complexity : O(1) count[] - constant space
*/