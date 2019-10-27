class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        result = []
        if root is None:
            return result
        
        result.append([root.val])
        
        
        for c in root.children:
            r = self.levelOrder(c)
            
            for i in range(len(r)):
                if len(result) <= i + 1:
                    result.append([])
                    
                result[i+1].extend(r[i])
