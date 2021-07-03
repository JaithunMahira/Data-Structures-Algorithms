/* Leetcode Link : https://leetcode.com/problems/3sum-closest/

Question : 
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 

Constraints:

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4*/


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int previousValue = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            
            while(j < k) {
                int value = nums[i] + nums[j] + nums[k];
                if(Math.abs(value - target) < previousValue) {
                    previousValue = Math.abs(value - target);
                    result = value;
                }
                if(value > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        
        return result;
    }
}

/*
Time complexity : O(n^2)
Space complexity : O(1) - since only used for result
*/