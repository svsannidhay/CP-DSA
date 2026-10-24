package arrays;
import java.util.ArrayList;
import java.util.HashMap;

// Brute Force (Check all the unique pairs)
// TC: O(N^2)
// SC: O(1)
class Solution1 {
    public int[] twoSum(int [] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[] {i, j};
            }
        }
        return new int[] {-1, -1};
    }
}

// HashMap 
// TC: O(N) avg case, O(N^2) Worst case in case of collisions 
// SC: O(N)
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (h.containsKey(target - nums[i])) return new int[] {i, h.get(target - nums[i])};
            h.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}


// Sorting & two Pointers
// TC: O(NlogN)
// SC: O(1)
class Pair {
    int first;
    int second;
    Pair (int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<Pair> sortedNums = new ArrayList<Pair>();
        for (int i = 0; i < nums.length; i++) {
            Pair p = new Pair(nums[i], i);
            sortedNums.add(p);
        }
        sortedNums.sort((Pair a, Pair b) -> {
            if (a.first < b.first) return -1;
            if (a.first == b.first) return 0;
            else return 1;
        });
        int left = 0;
        int right = sortedNums.size() - 1;
        while (left < right) {
            if (sortedNums.get(left).first + sortedNums.get(right).first > target) {
                right--;
                continue;
            } 
            if (sortedNums.get(left).first + sortedNums.get(right).first == target) {
                return new int[] { sortedNums.get(left).second, sortedNums.get(right).second };
            }
            left++;
        }

        return new int[] {-1, -1};
    }
}