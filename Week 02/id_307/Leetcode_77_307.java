class Solution {
    private List<List<Integer>> list = new ArrayList<>();
    private Map<Integer, Integer> result = new HashMap<>();
    private void combine(int n, int start, int k, int level) {
        if (level == k) {
            list.add(new ArrayList(result.values()));
            return;
        }
        for (int i = start; i < n; i++) {
            if (result.containsValue(i + 1)) {
                continue;
            }
            result.put(level, i + 1);
            combine(n, i + 1, k, level + 1);
            result.remove(level);
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        combine(n, 0, k, 0);
        return this.list;
    }
}