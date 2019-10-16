##################暴力法###############
# 执行用时 :5872 ms
# def twoSum(nums, target):
#     a = [0,0]
#     for i in range(len(nums)-1):
#         for j in range(i+1,len(nums)):
#             if nums[i] + nums[j] == target:
#                 a[0] = i
#                 a[1] = j
#                 return a
#     return []
#######################################
# def twoSum(nums, target):
#     lens = len(nums)
#     j=-1
#     for i in range(lens):
#         if (target - nums[i]) in nums:
#             if (nums.count(target - nums[i]) == 1)&(target - nums[i] == nums[i]):#如果num2=num1,且nums中只出现了一次，说明找到是num1本身。
#                 continue
#             else:
#                 j = nums.index(target - nums[i],i+1) #index(x,i+1)是从num1后的序列后找num2                
#                 break
#     if j>0:
#         return [i,j]
#     else:
#         return []
########################################################
# def twoSum(nums, target):
#     lens = len(nums)
#     j=-1
#     for i in range(1,lens):
#         temp = nums[:i]
#         if (target - nums[i]) in temp:
#             j = temp.index(target - nums[i])
#             break
#     if j>=0:
#         return [j,i]
###########################################################
# 执行用时 :1044 ms
def twoSum(nums, target):
    for i in range(len(nums)):
            if(target-nums[i] in nums and i != nums.index(target-nums[i])):
                    return [i,nums.index(target-nums[i])]

n = [5, 3, 1, 9, 0]
target = 10
m = twoSum(n, target)
print(m)
############




