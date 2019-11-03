class LeetCode_78_487{

    /***
     *
     * 78题
     *
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     *
     * 笔记：回溯是执行一次深度优先遍历，一条路走下去，走不通的时候返回回来，继续执行，一直这样下去，直到回到起点
     *
     * @param nums
     * @return
     */
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return ans;
        }
        find(nums, 0, new ArrayList<Integer>());
        return ans;
    }

    public void find(int[] nums, int index, List<Integer> req) {
        // 没有显式的递归终止
        // 注意：Java 的引用传递机制，这里要 new 一下
        ans.add(new ArrayList<Integer>(req));
        for (int i = index; i < nums.length; i++) {
            req.add(nums[i]);
            find(nums, i + 1, req);
            // 组合问题，状态在递归完成后要重置
            req.remove(req.size() - 1);
        }
    }
}