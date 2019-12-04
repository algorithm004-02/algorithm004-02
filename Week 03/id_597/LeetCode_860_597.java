/**
 * 柠檬水找零
 * Created by yangwenwei on 2019/10/30.
 */
public class LeetCode_860_597 {
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int time5 = 0, time10 = 0;
            for (int bill : bills) {
                if (5 == bill) time5++;
                else if (10 == bill) {
                    time5--;
                    time10++;
                } else {
                    if (time10 > 0) {
                        time5--;
                        time10--;
                    } else time5 -= 3;
                }
                if (time5 < 0) return false;
            }
            return true;

        }
    }
}
