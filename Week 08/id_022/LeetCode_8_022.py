class Solution:
    def myAtoi(self, str: str) -> int:
        ds, de = ord('0'), ord('9')
        sign, start = 1, False
        result = 0
        for c in str:
            d = ord(c)
            if c == ' ' and not start:
                continue
            elif c == '-' and not start:
                sign, start = -1, True
            elif c == '+' and not start:
                sign, start = 1, True
            elif ds <= d <= de:
                start = True
                result = result * 10 + d - ds
                if result > 2**31:
                    break
            else:
                break
        return max(min(result * sign, 2**31 - 1), -2**31)
        