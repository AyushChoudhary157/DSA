// 81. Search in Rotated Sorted Array II
// Solved
// Medium
// Topics
// Companies
// There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

// Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

// Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

// You must decrease the overall operation steps as much as possible.

 

// Example 1:

// Input: nums = [2,5,6,0,0,1,2], target = 0
// Output: true
// Example 2:

// Input: nums = [2,5,6,0,0,1,2], target = 3
// Output: false
 

// Constraints:

// 1 <= nums.length <= 5000
// -104 <= nums[i] <= 104
// nums is guaranteed to be rotated at some pivot.
// -104 <= target <= 104


class Solution {
    public boolean search(int[] nums, int target) {
        int st = 0, end = nums.length - 1;

        while(st<=end){
            int mid = st + (end - st)/2;
            if(nums[mid] == target){
                return true;
            }

            if(nums[st] == nums[mid] && nums[mid] == nums[end]){ // edge case [3,1,3,3,3]
                st = st + 1;
                end = end - 1;
                continue;
            }

            if(nums[st] <= nums[mid]){ // left sorted
                if(nums[st] <= target && target <= nums[mid]){
                    end = mid - 1;
                }else{
                    st = mid + 1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[end]){ // right sorted
                    st = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }return false;
    }
}
