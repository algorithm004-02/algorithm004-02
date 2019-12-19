给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
示例 1:
输入: 2
输出: [0,1,1]
示例 2:
输入: 5
输出: [0,1,1,2,1,2]

动态规划+最高有效位：
利用已有的计数结果来生成新的计数结果。
public class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        // [0, b) is calculated
        while (b <= num) {
            // generate [b, 2b) or [b, num) from [0, b)
            while(i < b && i + b <= num){
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;   // reset i
            b <<= 1; // b = 2b
        }
        return ans;
    }
}
输入
2
输出
[0,1,1]
预期结果
[0,1,1]