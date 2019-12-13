/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 *
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        if (nums == null || nums.length == 0) {
            return list;
        }
        int[] p = new int[n];
        boolean[] used = new boolean[n];
        permuteHelp(nums, p, 0, used, list);
        return list;
    }

    public void permuteHelp(int[] nums, int[] p, int index, boolean[] used, List<List<Integer>> list) {
        if (index == nums.length) {
            list.add(new ArrayList<>());
            for (int number : p) {
                list.get(list.size() - 1).add(number);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            p[index] = nums[i];
            used[i] = true;
            permuteHelp(nums, p, index + 1, used, list);
            used[i] = false;
        }
    }
}