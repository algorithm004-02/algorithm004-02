import  java.util.Map;
import  java.util.HashMap;
public class LeetCode_1_047 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Map<Integer,Integer> aMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            aMap.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int another = target - curr;
            if (aMap.containsKey(another) && i != aMap.get(another).intValue()) {
                return new int[]{i,aMap.get(another)};
            }
        }
        return null;
    }
}