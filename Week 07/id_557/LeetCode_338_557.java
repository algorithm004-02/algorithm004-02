//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。 
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,1] 
//
// 示例 2: 
//
// 输入: 5
//输出: [0,1,1,2,1,2] 
//
// 进阶: 
//
// 
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 
// 要求算法的空间复杂度为O(n)。 
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。 
// 
// Related Topics 位运算 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //    public int[] countBits(int num) {
//        int[] ans = new int[num + 1];
//        //暴力循环解法
//        for (int i = 0; i <= num; i++) {
//            ans[i] = popCount(i);
//        }
//        return ans;
//    }
//
//    private int popCount(int n) {
//        int count = 0;
//        while (n != 0) {
//            n = n & (n - 1);
//            count++;
//        }
//        return count;
//    }

    //动态规划+最高有效位
//    public int[] countBits(int num) {
//        int[] ans = new int[num + 1];
//
//        int i = 0, b = 1;
//        while (b <= num) {
//            while (i < b & i + b <= num) {
//                ans[i + b] = ans[i] + 1;
//                i++;
//            }
//            i = 0;
//            b = b << 1;
//        }
//        return ans;
//    }
//}
    //动态规划+最低有效位
//    public int[] countBits(int num) {
//        int[] ans = new int[num + 1];
//        for (int i = 0; i <= num; i++) {
//            ans[i] = ans[i >> 1] + (i & 1);
//        }
//        return ans;
//    }

    //动态规划+最后设置位
    //思路：将最后一位1清零 对应的整数的1的个数+1
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
