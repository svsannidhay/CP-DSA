package arrays;

import java.util.Arrays;
import java.util.HashSet;

// LC: https://leetcode.com/problems/longest-consecutive-sequence/

// Brute Force 
// TC: O(N^2)
// SC: O(1)
class Solution1 {
    public boolean search(int [] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return true; 
        }
        return false;
    }

    public int longestConsecutive(int [] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int curr = nums[i] + 1;

            while(search(nums, curr)) {
                curr++;
                count++;
            }
            ans = Math.max(count, ans);
        }   
        return ans;
    }
}

// Sorting with breakpoints 
// TC: O(NlogN)
// SC: O(1)
class Solution2 {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int currAns = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                currAns = 1;
                continue;
            }
            if (nums[i] == nums[i-1] + 1) {
                currAns++;
            } else if (nums[i] == nums[i-1]) {
                continue;
            } else {

                ans = Math.max(ans, currAns);
                currAns = 1;
            }
        }
        ans = Math.max(ans, currAns);
        return ans;
    }
}

// HashSet and greedy
// TC: O(N)
// SC: O(N)
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> s = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            s.add(nums[i]);
        }

        int ans = 0;
        for(int curr: s) {
            int n = curr;

            if (s.contains(n-1)) {
                continue;
            }

            int count = 1;
            while (s.contains(n + 1)) {
                count++;
                n++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}