package Week07.Chapter16;

public class LeetCode_7_191 {
    public int hammingWeight(int n) {
        int cnt = 0;
        // 循环n中1的次数
        while (n != 0) {
            cnt++;
            // n &= (n - 1) 使n的最低位1清0
            n &= (n - 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        final LeetCode_7_191 test = new LeetCode_7_191();
        System.out.println(test.hammingWeight(10));
    }
}
