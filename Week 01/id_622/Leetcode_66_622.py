"""
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plus-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

class Solution:
    """
    方法一、把数组转成整数，再把整数加一，然后再转成数组，两次遍历O(n)
           没有数组操作
    """
    def plusOne(self, digits: List[int]) -> List[int]:
        ans = []
        x = len(digits)
        temp = 0
        for i in range(0, x):
            temp = temp*10 + digits[i]

        tempArr = temp+1
        result = str(tempArr)
        for j in result:
            ans.append(int(j))
        return ans
    """
    方法二、 从尾部往上遍历，如果为9的，则变为0，进入下一个循环
          如果为不为0，则返回+1以后的数组，否则继续循环
          判断边界条件，首位需要进位的情况，直接insert操作（O(n)）
          寻求更好的方案
    """
    def plusOne(self, digits: List[int]) -> List[int]:
        j = len(digits) - 1
        for i in range(j, -1, -1):
            digits[i] += 1
            digits[i] = digits[i] % 10
            if digits[i] != 0:
                return digits
        if digits[0] == 0:
            digits.insert(0, 1)
        return digits