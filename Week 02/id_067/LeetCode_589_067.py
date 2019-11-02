class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        res = []
        if root == None:
            return res
        Solution.recusion(self, root, res)
        return res
    
    def recusion(self, root, res):
        #res.append(root.val)
        for child in root.children:
            self.recusion(child, res)
        res.append(root.val)