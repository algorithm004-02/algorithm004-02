"""
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

例如，给定一个 3叉树 :

 



 

返回其层序遍历:

[
     [1],
     [3,2,4],
     [5,6]
]
 

说明:

树的深度不会超过 1000。
树的节点总数不会超过 5000。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    """
    1. 首先将根节点放入队列中。
    2. 从队列中取出第一个节点，并检验它是否为目标。
    3. 如果找到目标，则结束搜索并回传结果。
    4. 否则将它所有尚未检验过的直接子节点加入队列中。
    5. 若队列为空，表示整张图都检查过了——亦即图中没有欲搜索的目标。结束搜索并回传“找不到目标”。
    6. 重复步骤2。
    """
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        # 老规矩，返回边界
        if not root: return []
        # 把root放入栈中
        stack = [root]
        result = []
        while stack:
            temp = []
            # 定义一个缓存栈，缓存的思想
            next_stack = []
            # 遍历stack中的元素，通过维护stack，解决额外判断根结点的问题
            # 此方法需要巩固
            for node in stack:
                temp.append(node.val)
                # 遍历子节点，并且维护缓存
                for child in node.children:
                    next_stack.append(child)
            # 把缓存的值丢给stack
            stack = next_stack
            result.append(temp)
        return result

    # 国际站5行代码写法。。。。。
    def levelOrder(self, root):
        q, ret = [root], []
        # any()any() 函数用于判断给定的可迭代参数 iterable 是否全部为 False，则返回 False，
        # 如果有一个为 True，则返回 True。元素除了是 0、空、FALSE 外都算 TRUE。
        while any(q):
            ret.append([node.val for node in q])
            q = [child for node in q for child in node.children if child]
        return ret