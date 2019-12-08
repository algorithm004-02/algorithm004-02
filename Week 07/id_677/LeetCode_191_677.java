/**
 * @author woncz
 * @date 2019/11/28
 */
public class LeetCode_191_677 {

    public static void main(String[] args) {
        ISolution s1 = new Solution1();
        int cnt = s1.hammingWeight(8);
        System.out.println(cnt);

        cnt = s1.hammingWeight(7);
        System.out.println(cnt);

    }
}

interface ISolution {
    int hammingWeight(int n);
}

/**
 * bitwise: 消除最后一位的1
 */
class Solution1 implements ISolution {
    @Override
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            n &= n - 1;
            cnt++;
        }
        return cnt;
    }
}
