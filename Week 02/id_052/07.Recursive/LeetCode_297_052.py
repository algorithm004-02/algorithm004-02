# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:

    def __init__(self):
        self.strTree = []

    def serialize(self, root):
        """Encodes a tree to a single string.     
        :type root: TreeNode
        :rtype: str
        """
        if root == None:
            self.strTree.append("null")
            return self.strTree
        # 递归。将当前根节点转化为字符串，再将根节点的左右子树形成字符串。
        curStr = str(root.val)
        self.strTree.append(curStr)
        # print(self.strTree) 查看当前序列化情况
        self.serialize(root.left)
        self.serialize(root.right)
        
        return self.strTree
        
        
    def deserialize(self, data):
        """Decodes your encoded data to tree.   
        :type data: str
        :rtype: TreeNode
        """
        if len(data) == 1 and data[0] == "null":
            return None
        # 每次取字符串数组的第一个元素，判断该元素的位置。
        # 由于使用递归，每次取出一个元素后将其在原数组中移出。
        tmp = data[0]
        data.remove(tmp)
        
        # 如果该元素为空，则说明，到达叶节点。
        # 返回None，当前分支已生成完毕，退回到上一层递归。
        if tmp == "null":
            return None
        # 如果字符不为null，则将其转换成整型数，建立一个树节点。
        # 递归的生成左子树和右子树。
        root = TreeNode(int(tmp))
        # 序列化的时候先左后右，反序列化的时候也要先左后右。
        root.left = self.deserialize(data)
        root.right = self.deserialize(data)
        
        return root

#https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/solution/pythondi-gui-by-1718zhangyq/