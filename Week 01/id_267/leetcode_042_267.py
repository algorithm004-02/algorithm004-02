##############挖地法优化版################
# 挖地法：按照柱子的高度来循环，求和每层高度为0的个数（此处有水坑）。每层楼去除首尾是0的元素，两端的0不积水。
# 优化： 添加左右指针
# 执行用时 : 60 ms
# class Solution:
#     def trap(self, height):
#         rain_area, hl, hr = 0, 0, 0
#         for i in range(len(height)):
#             hl = max(hl, height[i])
#             hr = max(hr, height[-i-1])
#             rain_area = rain_area + hl + hr - height[i]
#         return rain_area - len(height)*hl
######################


class Solution:
    def trap(self, height):
        a, b, rain_area, leftmax, rightmax = 0, len(height)-1, 0, 0, 0
        while a <= b:
            leftmax = max(leftmax, height[a])
            rightmax = max(rightmax, height[b])
            if leftmax < rightmax:
                rain_area += (leftmax-height[a])
                a += 1
            else:
                rain_area += (rightmax-height[b])
                b -= 1
        return rain_area


##############测试用例#####################
height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
obj = Solution()
print(obj.trap(height))
