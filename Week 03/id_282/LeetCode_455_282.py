class Solution:
    """
    贪心问题。优先满足胃口小的小朋友的需求。
    对 g 和 s 升序排序
    初始化两个指针 i 和 j 分别指向 g 和 s 初始位置
    对比 g[i] 和 s[j]
    g[i] <= s[j]：饼干满足胃口，把能满足的孩子数量加 1，并移动指针 i = i + 1，j = j + 1
    g[i] > s[j]：无法满足胃口，j 右移，继续查看下一块饼干是否可以满足胃口
    """
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        res = 0
        g.sort()
        s.sort()
        
        g_length = len(g)
        s_length = len(s)
        
        i = 0
        j = 0
        while i < g_length and j < s_length:
            if g[i] <= s[j]:
                # 可以满足胃口，把小饼干喂给小朋友
                res += 1
                i += 1
                j += 1
            else:
                # 不满足胃口，查看下一块小饼干
                j += 1
                
        return res
