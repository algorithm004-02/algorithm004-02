package Week03.Chapter10;

public class LeetCode_3_860 {
    // https://leetcode-cn.com/problems/lemonade-change/description/
    public boolean lemonadeChange(int[] bills) {
        // where is greedy ?
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int []bills=new int[]{5,5,10,20,5,10};
        final LeetCode_3_860 test = new LeetCode_3_860();
        System.out.println(test.lemonadeChange(bills));
    }
}
