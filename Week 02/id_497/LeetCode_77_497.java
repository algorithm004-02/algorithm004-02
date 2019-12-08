class Solution {
    List<List<Integer>> list = new ArrayList<>();

    int n, k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        getList(new Stack<Integer>(), 1);
        return list;
    }

    private void getList(Stack<Integer> integers, int start) {
        if (integers.size() == k) {
            list.add(new LinkedList<>(integers));
        }
        for (int i = start; i < n + 1; ++i) {
            integers.add(i);
            getList(integers, i + 1);
            integers.pop();
        }

    }

}