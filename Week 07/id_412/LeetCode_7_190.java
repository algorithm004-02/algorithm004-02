package Week07.Chapter16;

public class LeetCode_7_190 {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // n & 1 --> 取出n的最低位
            // System.out.printf("第%d位为%d\n", i, n & 1);
            // result左移
            result <<= 1;
            result |= n & 1;
            // n右移
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        final LeetCode_7_190 test = new LeetCode_7_190();
        System.out.println(test.reverseBits(43261596));
    }
}
