
public class Solution {

    public int[] twoSum(int[] nums, int target) throws Exception {

        Map<Integer, Integer> map = new HashMap<>();

        // 放到hash Map
        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i], i);
        }


        for(int i = 0; i < nums.length; i ++) {

            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                return new int[] {i, map.get(diff)};
            }
        }

        throw new Exception();
    }
}
