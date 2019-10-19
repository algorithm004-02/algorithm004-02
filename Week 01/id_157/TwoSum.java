import java.util.HashMap;

/**
 * Created by kaiyun on 2019/10/18.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> con = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int one = target - current;
            if (con.containsKey(one)) {
                return new int[]{con.get(one), i};
            }
            con.put(current, i);
        }
        return null;
    }
}
