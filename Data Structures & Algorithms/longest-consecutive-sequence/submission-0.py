class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nSet = set(nums)
        longest = 0

        for num in nSet:
            if num - 1 not in nSet:
                curr = num
                length = 1

                while curr + 1 in nSet:
                    curr += 1
                    length += 1
                longest = max(longest, length)
        return longest