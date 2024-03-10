// 349. Intersection of Two Arrays
// Solved
// Easy
// Topics
// Companies
// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
// Example 2:

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
// Explanation: [4,9] is also accepted.
 

// Constraints:

// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000

class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> resultList = new ArrayList<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num) && !resultList.contains(num)) {
                resultList.add(num);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
        
    }
}