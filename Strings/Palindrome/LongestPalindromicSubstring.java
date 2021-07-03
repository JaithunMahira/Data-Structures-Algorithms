/* Leetcode Link : https://leetcode.com/problems/longest-palindromic-substring/

Question : 
Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case), */

class Solution {
    public String longestPalindrome(String s) {
        
        if(s.length() == 0) return "";
        int left = 0;
        int right = 0;
        
        for(int i = 0; i < s.length(); i++) {
            int len1 = expandFromMid(i, i, s);
            int len2 = expandFromMid(i, i + 1, s);
            
            int len = Math.max(len1, len2);
            
            if(len > right - left) {
                left = i - (len - 1)/2;
                right = i + (len/2);
            }
        }
        
        return s.substring(left, right + 1);
    }
    
    
    private int expandFromMid(int left, int right, String s) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}


/*
Time complexity : O(n^2)
Space complexity : O(1)
*/