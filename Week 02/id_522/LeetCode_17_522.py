class Solution:

    def fun(self,digits,n,result,data):
        if n>=self.size: return

        ch = digits[n]
        r = self.dp[ch]
        index = 0
        while index < len(r):
            _data = data + r[index]

            if len(_data) == self.size :
                result.append(_data)
            else:
                self.fun(digits,n+1,result,_data)

            index = index+1


    def letterCombinations(self, digits: str) -> List[str]:

        self.size =len(digits)
        if 0 == self.size : return []

        self.dp = {'2':'abc','3':'def','4':'ghi','5':'jkl','6':'mno',
              '7':'pqrs','8':'tuv','9':'wxyz'}

        result = []
        self.fun(digits,0,result,"")
        return result
