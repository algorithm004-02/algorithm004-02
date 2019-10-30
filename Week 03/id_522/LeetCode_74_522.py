'''第一次
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        for i in matrix:
            for j in i:
                if j==target:return True
        else:
            return False

'''


# 第二次

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        for i in matrix:
            if target in i :return True

        return False


'''
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        if not matrix  :return False  
        
        
        ll=len(matrix)
        if ll==1 :
            if target in matrix[0] :return True
            else:
                return False  
                
            #return if k in matrix[0]
        
        left ,right =0,ll
        loopcount=65
        while left<right and loopcount:
            loopcount-=1
            mid= left +right >>1
            if matrix[mid][0]==target :
                return True
            
            if matrix[mid][0]>target :
                right =mid-1
                #print(right)
            else:
                left =mid
                #print(left)
        try:        
            if target in matrix[left]+matrix[right]:
                return True
        except:
            if target in matrix[left]:
                return True

        return False  
'''
