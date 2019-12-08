// https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/

public class Codec {

    // Encodes a tree to a single string.
    // 递归
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        stringify(root, sb);
        String res = sb.toString();
        return res;

    }
    private void stringify(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(",");
            return;
        }
        sb.append(root.val).append(",");
        stringify(root.left, sb);
        stringify(root.right, sb);
    }

    // Decodes your encoded data to tree.
    // todo: 错误代码
    // public TreeNode deserialize(String data) {
    //     String[] charArr = data.split(",");
    //     TreeNode root = new TreeNode(Integer.valueOf(charArr[0]));
    //     return treefy(root, charArr, 0);
    // }
    // private TreeNode treefy(TreeNode root, String[] data, int index) {
    //     if (index >= data.length) return null;
    //     if (data[index].equals("null")) {
    //         return null;
    //     }

    //     root = new TreeNode(Integer.valueOf(data[index]));
    //     root.left = treefy(root, data, index+1);
    //     root.right = treefy(root, data, index+2);
    //     return root;
    // }
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals("null")) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}