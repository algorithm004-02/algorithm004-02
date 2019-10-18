# 1. 暴力
# 执行用时 : 780 ms

# def maxSlidingWindow(nums, k):
#     res = []
#     if nums != []:
#         temp_max = max(nums[0:k])
#         for i in range(len(nums)-(k-1)):
#             temp_max = max(nums[i:i+k])
#             res.append(temp_max)
#     return res


# 2. Deque
def maxSlidingWindow(nums, k):
    win, res = [], []
    for i, v in enumerate(nums):
        if i >= k and win[0] <= i - k:
            win.pop(0)
        while win and nums[win[-1]] <= v:
            win.pop()
        win.append(i)
        if i >= k - 1:
            res.append(nums[win[0]])
    return res


nums = [1, 3, -1, -3, 5, 3, 6, 7]
k = 3
a = maxSlidingWindow(nums, k)
print(a)
