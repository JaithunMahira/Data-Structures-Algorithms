/* Leetcode Link :https://leetcode.com/problems/letter-combinations-of-a-phone-number/
Question : 

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9']. */

class Solution {
    HashMap<Integer, String> hMap = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        hMap.put(2, "abc");
        hMap.put(3, "def");
        hMap.put(4, "ghi");
        hMap.put(5, "jkl");
        hMap.put(6, "mno");
        hMap.put(7, "prqs");
        hMap.put(8, "tuv");
        hMap.put(9, "wxyz");

        ArrayList<String> result = new ArrayList<>();
        if(digits.length() == 0){
            return result;
        }
        
        getCombinations(0, digits, result, "");
        return result;
    }
    
    private void getCombinations(int index, String digits, ArrayList<String> result, String tempString) {
        if(index == digits.length()){
            result.add(tempString);
            return;
        }
        String numbers = hMap.get(Character.getNumericValue(digits.charAt(index)));
        
        for(int i = 0; i < numbers.length(); i++) {
            getCombinations(index + 1, digits, result, tempString + numbers.charAt(i));
        }
    }
}

//Time complexity :  O(3N×4M) N - number of three char numbers M - number of four character numbers
//Space complexity : O(3N×4M) - Space