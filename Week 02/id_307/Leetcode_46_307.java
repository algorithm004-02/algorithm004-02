class Solution {
    private List<List<Integer>> list = new ArrayList<>();
    private List<Integer> result = new ArrayList<>();
    private Map<Integer, Boolean> occupied = new HashMap<>();
    private void permute(int[] nums, int level) {
        if (level == nums.length) {
            list.add(new ArrayList(result));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (occupied.containsKey(nums[i])) {
                continue;
            }
            result.add(nums[i]);
            occupied.put(nums[i], true);
            permute(nums,level + 1);
            occupied.remove(nums[i]);
            result.remove(level);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0);
        return list;
    }
}