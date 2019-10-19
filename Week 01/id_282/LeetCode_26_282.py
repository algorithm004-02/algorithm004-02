class Solution:
    """
        1、验证是否为数组list
        2、filter 数组去重复
    """        
    def __init__(self,nums): 
        self._nums=nums
    
    def removeDuplicates(self):
        return list(filter(lambda x:self._nums.count(x) ==1, self._nums))
    
list1 = [1, 2, 3, 4, 5, 6, 6,8,8]
newslist=Solution(list1)  
print(newslist.removeDuplicates())