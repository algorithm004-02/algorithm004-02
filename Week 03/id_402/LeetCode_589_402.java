Thinking:
参考二叉树的前中后序遍历的写法，修改后变成N节点树的中序遍历。

Code:
java
思想1

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        DLR_Nodes(root, list);
        return list;
    }

    //开始递归
    private void DLR_Nodes(Node root, List<Integer> list){
        if (root == null) {//terminator 递归终止条件 当子节点为空
            return;
        }
        list.add(root.val);// process logic current level 当前处理逻辑
        for (Node child : root.children) {
            DLR_Nodes(child, list);  //drill down 试探道下一层
        } 
        //reverse the current level status if needed  如有需要时，处理缓存或者零时变量
    }
}