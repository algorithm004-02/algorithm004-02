class Solution(object):
    def relativeSortArray(self, arr1, arr2):
        """
        :type arr1: List[int]
        :type arr2: List[int]
        :rtype: List[int]
        """
        import collections
        ans = []
        hashmap = collections.Counter(arr1)
        for i in arr2:
            for j in range(hashmap[i]):
                ans.append(i)
                arr1.remove(i)
        return ans + sorted(arr1)


'''
class Solution:
    def relativeSortArray(self, arr1, arr2):
    # jishu paixu
        jishu= [0]*1001
    
        ll=len(arr1)
        for i in range(ll):
            jishu[arr1[i]] +=1
        res=[]
        for k in arr2:
            while jishu[k]:
                res.append(k)
                jishu[k]-=1
        
        for j in range(1001):
            while jishu[j]:
                res.append(j)
                jishu[j]-=1
        
        return res

'''
