#
# @lc app=leetcode.cn id=74 lang=python3
#
# [74] 搜索二维矩阵
#

# @lc code=start
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        def search(nums, target):
            left, right = 0, len(nums) - 1
            while left <= right:
                mid = (left + right) // 2
                #print('target={}mid={}'.format(target,nums[mid]))
                if target == nums[mid]:                    
                    return True
                else:
                    if target > nums[mid]:
                        left = mid + 1
                    else:
                        right = mid - 1
            #return False
            

        #return search([1,3,5,7],3)
        ma = []
        for n in range(0, len(matrix)):
            ma += matrix[n]
        return search(ma, target)
        

        
# @lc code=end

