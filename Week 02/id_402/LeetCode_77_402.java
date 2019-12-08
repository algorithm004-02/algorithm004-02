class Solution {
//大神代码 深度优先 
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> retList = new ArrayList<>();
        dfs(retList, new LinkedList<>(), 0, 1, n, k);
        return retList;
    }

    private void dfs(List<List<Integer>> retList,
                     List<Integer> itemList,
                     int preNum,
                     int index,
                     int n,
                     int k) {
        if (itemList.size() == k) {
            retList.add(new LinkedList<>(itemList));
            return;
        }
        for (int i = preNum + 1; i <= n - k + index; i++) {
            itemList.add(i);
            dfs(retList, itemList, i, index + 1, n, k);
            itemList.remove(itemList.size() - 1);
        }
    }
}