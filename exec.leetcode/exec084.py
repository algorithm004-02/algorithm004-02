# 1. 暴力：
    #  for i->0, n-2
    #      for j->i+1, n-1
    #          (i, j)-> 最小高度, area
    #          update max-area
# 2. 暴力2：
    # for i->0, n-1
    #     找到left bound, right bound,
    #     area = height[i] * (right-left)
    #     update max-area
# 