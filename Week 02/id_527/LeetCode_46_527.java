/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        allSort(new LinkedList<>());
        return result;
    }

    void allSort(LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (Integer i : nums) {
            if (list.contains(i)) {
                continue;
            }
            list.add(i);
            allSort(list);
            list.removeLast();
        }
    }
}
// @lc code=end
