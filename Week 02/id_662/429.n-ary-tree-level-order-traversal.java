/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 返回其层序遍历:
 * <p>
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 */

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> temp = new ArrayList<>();
            while(count != 0){
                Node cur = queue.poll();
                temp.add(cur.val);
                for(Node ch : cur.children){
                    queue.offer(ch);
                }
                count--;
            }
            list.add(temp);
        }
        return list;
    }
}