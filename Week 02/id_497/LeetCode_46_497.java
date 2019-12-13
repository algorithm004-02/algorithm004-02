class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    LinkedList<Integer> oriList = new LinkedList<>();
    Map<String, Integer> map = new HashMap<>();

    public List<List<Integer>> permute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            oriList.add(nums[i]);
        }
        boolean[] booleans = new boolean[nums.length];
        getList(oriList, booleans, new LinkedList<>());
        return lists;
    }

    private void getList(LinkedList<Integer> nums, boolean[] booleans, LinkedList<Integer> integers) {
        if (integers.size() == oriList.size()) {
            if (map.get(integers.toString()) == null) {
                lists.add(new LinkedList<>(integers));
                map.put(integers.toString(), 0);
                return;
            }
        }
        for (int i = 0; i < nums.size(); i++) {
            // place i-th integer first
            // in the current permutation
            if (!booleans[i]) {
                booleans[i] = true;
                integers.add(nums.get(i));
                getList(nums, booleans, integers);
                integers.removeLast();
                booleans[i] = false;
            }

        }

    }
}