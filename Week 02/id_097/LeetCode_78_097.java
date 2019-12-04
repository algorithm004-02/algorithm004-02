class Solution {
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> list = new ArrayList<>();
        _mySubsets(list, 0, nums);

        return result;
    }

    private void  _mySubsets(List<Integer> list, int index, int[] nums) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        _mySubsets(list, index + 1, nums);

        list.add(nums[index]);

        _mySubsets(list, index + 1, nums);

        list.remove(list.size() - 1);
    }
}