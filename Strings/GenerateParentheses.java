/* Leetcode Link : https://leetcode.com/problems/generate-parentheses/
Question : 

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8*/

class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate("", n, n);
        return result;
    }

    private void generate(String str, int left, int right) {
        if(left == 0 && right == 0) {
            result.add(str.toString());
            return;
        }
        if(left > 0) {
            generate(str + "(", left - 1, right);
        }
        if(left < right) {
            generate(str + ")", left, right - 1);
        }
    }
}


/*
Time complexity : O(2 ^ (2)n)
Space complexity :O(n) - stack space
*/