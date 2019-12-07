package Week07.Chapter16;

public class LeetCode_7_231 {
    public boolean isPowerOfTwo(int n) {
        // n的二进制表示里有且仅有一位是1 --> n & (n - 1) == 0
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        final LeetCode_7_231 test = new LeetCode_7_231();
        System.out.println(test.isPowerOfTwo(10));
        System.out.println(test.isPowerOfTwo(8));
    }
}
