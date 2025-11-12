from typing import List


class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        for item in nums:
            index = abs(item) - 1
            if nums[index] < 0:
                return abs(item)
            nums[index] *= -1
        return -1

nums = [1, 2, 3, 2, 2]
solution = Solution()
print(solution.findDuplicate(nums))
                