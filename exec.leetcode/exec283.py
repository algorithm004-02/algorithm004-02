nums = [0, 0, 0, 19, 23, 4]
########################传统index###########################
# 执行用时 :60 ms
# j = 0
# for i in range(len(nums)):
#     if nums[i] != 0:
#         nums[j] = nums[i]
#         if i != j:
#             nums[i] = 0
#         j += 1
# print(nums)
##################python独门必杀######################
# 执行用时 :220 ms
# for i in range(len(nums)):
#     if nums[i] == 0:
#         nums.append(0)
#         nums.remove(0)
# print(nums)
# ------------------直接下标----------
# 执行用时 :140 ms
# for i in nums[:]:
#     if i == 0:
#         nums.append(0)
#         nums.remove(0)
# print(nums)
# ------------------------
# 执行用时 : 60 ms
j = 0
for i in range(len(nums)):
    if nums[i] != 0:
        nums[i], nums[j] = nums[j], nums[i]
        j += 1
print(nums)
#################一行必杀#######################
# Leetcode中没有通过
# nums.sort(key=bool)
# print(nums)
