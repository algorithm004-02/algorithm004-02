class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # 使用字典后比较
        if len(s) != len(t):
            return False
            
        count_s = {}
        count_t = {}
        
        for i in range(len(s)):
            if s[i] not in count_s:
                count_s.update({s[i]: 0})
            if t[i] not in count_t:
                count_t.update({t[i]: 0})
                
            count_s[s[i]] += 1
            count_t[t[i]] += 1
        
        return count_s == count_t
