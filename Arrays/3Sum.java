/* Leetcode Link : https://leetcode.com/problems/3sum/

Question : 
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105 */


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Set<List<Integer>> list = new HashSet<List<Integer>>(); //so repeated answers are avoided
        
        if(nums.length == 0) return new ArrayList<>(list);
        Arrays.sort(nums);
        int j = 0; int k = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            j = i + 1;
            k = nums.length - 1;
            
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                } else if(sum > 0)
                    k--;
                else
                    j++;
            }
        }
        
        return new ArrayList<>(list);
    }
}


/*
Time complexity : O(n^2)
Space complexity : O(1) - since only used for result
*/