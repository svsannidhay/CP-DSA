package arrays;

import java.util.Arrays;
import java.util.HashMap;

// Brute Force
// TC: O(N^2)
// SC: O(1)
class Solution1 {
    public int majorityElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
          int count = 0;
          for (int j = 0; j < nums.length; j++) {
            if (nums[j] == nums[i]) {
                count++;
                if (count > nums.length/2) return nums[i];
            }
          }   
        }
        return -1;
    }
}

// Sort and breakpoints 
// TC: O(NlogN)
// SC: O(1)
class Solution2 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int ans = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ans) {
                count++;
            } else {
                ans = nums[i];
                count++;
            }
            if (count > nums.length / 2) return ans;
        }
        return ans;
    }
}

// HashMap -> Frequency Map
// TC: O(N), O(N^2) worst case in collisions
// SC: O(N)
class Solution3 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int i =0; i < nums.length; i++) {
            if (h.containsKey(nums[i])) {
                h.put(nums[i], h.get(nums[i]) + 1);
            }
            else {
                h.put(nums[i], 1);
            }
            if (h.get(nums[i]) > nums.length / 2) return nums[i];
        }
        return -1;
    }
}   

// Count (Exploit the fact that count > n/2) 
// TC: O(N)
// SC: O(1)
class Solution4 {
    public int majorityElement(int[] nums) {
        int runningAns = nums[0];
        int runnerCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (runningAns == nums[i]) {
                runnerCount++;
            } else {
                runnerCount--;
            }
            if (runnerCount == 0) {
                runningAns = nums[i];
                runnerCount = 1;
            }
        }
        return runningAns;
    }
}