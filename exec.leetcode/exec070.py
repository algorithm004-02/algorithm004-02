# 思路：
# 懵逼的时候：暴力？暴力出奇迹？基本情况？
# 化繁为简 找最近重复子问题，然后泛化
# 1：1
# 2：2
# 3：f(1) + f(2)
# 4: f(2) + f(3)
# f(n) = f(n-1) + f(n-2) : Fibonacci


def climbStairs(n):
    if (n <= 2):
        return n
    f1, f2, f3 = 1, 2, 3
    for i in range(3, n+1):
        f3 = f1+f2
        f1 = f2
        f2 = f3
    return f3


n = climbStairs(8)
print(n)
