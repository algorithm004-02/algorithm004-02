/**
 全排列
 */
class Solution {

    List<List<Integer>> results = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return results;
        }
        permute2(nums,new ArrayList<Integer>());
        return results;

    }

    private void permute2(int[] nums,
                          ArrayList<Integer> tempList) {

        if (tempList.size() == nums.length) {
            results.add(new ArrayList<Integer>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (!tempList.contains(current)) {
                tempList.add(current);
                permute2(nums,tempList);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}


