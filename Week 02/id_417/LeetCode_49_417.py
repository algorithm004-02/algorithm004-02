class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # 利用哈希映射函数
        prime = [ 2,  3,  5,  7, 11, 
                 13, 17, 19, 23, 29, 
                 31, 37, 41, 43, 47, 
                 53, 59, 61, 67, 71,
                 73, 79, 83, 89, 97,
                 101]
        
        result = {}
        
        for s in strs:
            num = 1
            
            for _ in s:
                num *= prime[ord(_)-97]
            
            if num not in result:
                result[num] = []
                
            result[num].append(s)
        
        return [v for k, v in result.items()]
