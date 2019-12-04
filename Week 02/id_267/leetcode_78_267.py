# 硬币兑换/走楼梯/括号问题

# class Solution:
#     def subsets(self, nums):
#         subsets =[[]]

#         for num in nums:
#             newsets = []
#             for subset in subsets:
#                 new_subset = subset + [num]
#                 newsets.append(new_subset)
#             subsets.extend(newsets)

#         return subsets

###############选数字法##################


class Solution:

    def subsets(self, nums):
        ans = []
        if nums == []:
            return [[]]
        self.dfs(ans, nums, list, 0)
        return ans

    def dfs(self, ans, nums, list, index):

        # terminator
        if index == len(nums):
            ans.append(list)
            return

        # not pick the number at this index
        self.dfs(ans, nums, list, index+1)

        list.append(nums[index])
        # pick the number at this index
        self.dfs(ans, nums, list, index+1)

        # reverse the current state
        list.pop()


################test cases##############
nums = [1,2]
obj = Solution()
print(obj.subsets(nums))
