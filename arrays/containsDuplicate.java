package arrays;

import java.util.Arrays;
import java.util.HashSet;

// LC: https://leetcode.com/problems/contains-duplicate/

// Brute Force check all the pairs
// TC: O(N^2)
// SC: O(1)
class Solution1 {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}

// Sort and check adjacent 
// TC: O(NlogN)
// SC: O(1)
class Solution2 {
    public boolean containsDuplicate(int [] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) return true;
        }
        return false;
    }
}

// HashSet 
// TC: O(N), O(N^2) incase of collisions 
// SC: O(N)
class Solution3 {
    public boolean containsDuplicate(int [] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;

            set.add(nums[i]);
        }
        return false;
    }
}

class Solution4 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> h = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            h.add(nums[i]);
        }
        if (h.size() < nums.length) return true;
        return false;
    }
}
