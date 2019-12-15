# https://leetcode-cn.com/problems/jewels-and-stones/

# 暴力法
class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        count = 0
        for i in J:
            for j in S:
                if i == j:
                    count += 1
        return count


# 哈希法
class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        data = {}
        for j in S:
            if j not in data:
                data[j] = 1
            else:
                data[j] += 1
        count = 0
        for i in J:
            count += data.get(i, 0)
        return count

