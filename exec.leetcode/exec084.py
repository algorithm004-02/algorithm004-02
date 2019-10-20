# 1. 暴力1：先找到最大的左右边界，再找左右边界中最小那个高度，即数组的下标差
    #  for i->0, n-2
    #      for j->i+1, n-1
    #          (i, j)-> 最小高度, area
    #          update max-area
# 2. 暴力2：暴力1的加速，固定1根柱子，找到比它小的左右柱子，计算面积，循环比较所有面积即可
    # for i->0, n-1
    #     找到left bound, right bound,
    #     area = height[i] * (right-left)
    #     update max-area
# 3. Stack
#    创建一个栈，栈内元素是从小到大排列的（从栈底到栈顶从小到大）