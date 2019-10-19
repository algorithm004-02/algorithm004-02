class Solution:
    """
        1、验证是否为数组list
        2、filter 数组去重复
    """        
    def __init__(self,nums): 
        self._nums=nums
    
    def removeDuplicates(self):
        i = 0
        for num in self._nums:
            if self._nums[i]!=num:
                i += 1
                self._nums[i] = num
        
        return len(self._nums)and i+1
    
list1 = [0,0,1,1,1,2,2,3,3,4]
newslist=Solution(list1)  
print(newslist.removeDuplicates())