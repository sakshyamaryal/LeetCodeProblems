# Given an array nums of size n, return the majority element.
# The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 
# Example 1:
# Input: nums = [3,2,3]Output: 3
 
# Example 2:
# Input: nums = [2,2,1,1,1,2,2]Output: 2
 
 class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dict = {}
       
        for i in nums:
            if i not in dict:
                dict[i] = 1
            elif i in dict:
                dict[i] += 1
               
 
        inverse = [(value, key) for key, value in dict.items()]
        return (max(inverse)[1])