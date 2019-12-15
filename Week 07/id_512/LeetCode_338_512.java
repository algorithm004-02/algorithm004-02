package WEEK6.LeetCode.Bits;
/**
* No.338
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
*
* */
public class CountBits_338 {


        public int[] countBits(int num) {
            int[] ans = new int[num + 1];
            for (int i = 0; i <= num; ++i)
                ans[i] = popCount(i);
            return ans;
        }
        private int popCount(int x) {
            int count;
            for (count = 0; x != 0; ++count)
                x &= x - 1; //zeroing out the least significant nonzero bit
            return count;
        }


        //P(x)=P(x/2)+(x mod 2)

        public int[] countBits2(int num) {
            int[] ans = new int[num + 1];
            for (int i = 1; i <= num; ++i)
                ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
            return ans;
        }

        //P(x)=P(x&(x−1))+1;

        public int[] countBits3(int num) {
            int[] ans = new int[num + 1];
                for (int i = 1; i <= num; ++i)
                ans[i] = ans[i & (i - 1)] + 1;
            return ans;
        }


}
