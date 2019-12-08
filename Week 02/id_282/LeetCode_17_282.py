class Solution:
    '''
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    '''
    def letterCombinations(self, digits: str) -> List[str]:
        lookup = {
            "2":"abc",
            "3":"def",
            "4":"ghi",
            "5":"jkl",
            "6":"mno",
            "7":"pqrs",
            "8":"tuv",
            "9":"wxyz"
        }
        if not digits:
            return []
        res = [""]
        for num in digits:
            next_res = []
            for alp in lookup[num]:
                for tmp in res:
                    next_res.append(tmp + alp)
            res = next_res
        return res