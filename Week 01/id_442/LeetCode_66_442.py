# https://leetcode-cn.com/problems/plus-one/

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        # 从后向前遍历
        for i in range(len(digits)-1, -1, -1):
            # 小于9 加1即是结果
            if digits[i] < 9:
                digits[i] += 1
                return digits
            # 否则此位置0 继续循环处理前一位
            digits[i] = 0
        # 处理类似于999...的数组 最高位补1
        digits.insert(0, 1)
        return digits
