public class Solution {
        private int[] preorder;
        private int[] inorder;
        private Dictionary<int, int> inorderDic = new Dictionary<int, int>();
        private int preIndex = 0;


        public TreeNode BuildTree(int[] preorder, int[] inorder){
            if (preorder == null || inorder == null || preorder.Length != inorder.Length){
                return null;
            }

            this.preorder = preorder;
            this.inorder = inorder;

            for (int index = 0; index < inorder.Length; index++){
                inorderDic.Add(inorder[index], index);
            }

            return BuildTree(0, inorder.Length-1);
}

        private TreeNode BuildTree(int start, int end){
            if (start > end){
                return null;
            }

            var pivot = preorder[preIndex];
            TreeNode node = new TreeNode(pivot);
            var index = inorderDic[pivot];
            preIndex++;

            node.left = BuildTree(start, index-1);
            node.right = BuildTree(index+1, end);

            return node;
        }
}

class Solution {
  // start from first preorder element
  int pre_idx = 0;
  int[] preorder;
  int[] inorder;
  HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

  public TreeNode helper(int in_left, int in_right) {
    // if there is no elements to construct subtrees
    if (in_left == in_right)
      return null;

    // pick up pre_idx element as a root
    int root_val = preorder[pre_idx];
    TreeNode root = new TreeNode(root_val);

    // root splits inorder list
    // into left and right subtrees
    int index = idx_map.get(root_val);

    // recursion 
    pre_idx++;
    // build left subtree
    root.left = helper(in_left, index);
    // build right subtree
    root.right = helper(index + 1, in_right);
    return root;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    this.preorder = preorder;
    this.inorder = inorder;

    // build a hashmap value -> its index
    int idx = 0;
    for (Integer val : inorder)
      idx_map.put(val, idx++);
    return helper(0, inorder.length);
  }
}
