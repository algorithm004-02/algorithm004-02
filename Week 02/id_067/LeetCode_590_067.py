class Solution:     
    def postorder(self, root: 'Node') -> List[int]:
        res = []
        if root == None : 
            return res           
        Solution.recursion(self, root, res)
        return res

    def recursion(self, root, res):
        res.append(root.val)
        for child in root.children:
            self.recursion(child, res)