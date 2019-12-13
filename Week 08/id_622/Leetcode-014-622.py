"""
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-common-prefix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        # Step 1: 找出第一个参考字符串，对此字符串进行遍历，游标为i
        # Step 2: 在遍历第一个字符串的同时，对剩余的每个数组元素的同样位置进行比较
        # Step 3: 如果此时相等，则继续往下遍历，不等的话，则返回游标之前的元素
        if not strs: return ""
        n = len(strs)
        m = len(strs[0])
        
        for i in range(m):
            tmp = strs[0][i]
            for j in range(1, n):
                #终止条件：游标位置元素与数组中比对元素不等，或者长度等于数组元素长度，无法继续下行
                #####
                # 注意： i == len(strs[j]) 为True时，or 后面不执行
                # 顺序调换则 会out of range
                #####
                if i == len(strs[j]) or strs[j][i] != tmp:
                    return strs[0][:i]
        return strs[0]