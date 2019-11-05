
//两数之和
 class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {

            int sub = target - nums[i];

            if(map.containsKey(sub)){
                res[0] = map.get(sub);
                res[1] = i;

                return res;
            }
            map.put(nums[i],i);
        }
        return null;
    }
}