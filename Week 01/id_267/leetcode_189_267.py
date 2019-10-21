############python特性################
# 执行用时 :172 ms
# def rotate(self,nums, k):
#     for _ in range(k):
#         nums.insert(0,nums.pop())

#############暴力旋转###############
# 执行用时 :超时！！

# def rotate(nums, k):
#     for i in range(k):
#         previous = nums[len(nums)-1]
#         for j in range(len(nums)):
#             nums[j], previous = previous, nums[j]
#             j += 1
#         i += 1

##############额外数组#####################
# 执行用时 :72 ms
def rotate(nums, k):
    a = [None]*len(nums)
    for i in range(len(nums)):
        m = (i+k) % len(nums)
        a[m] = nums[i]
        i += 1
    for i in range(len(nums)):
        nums[i] = a[i]
        i += 1
    # return nums

##############测试数据#####################
nums = [-1, -100, 3, 99, 0]
k = 3
print(rotate(nums, k))