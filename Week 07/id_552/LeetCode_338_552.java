package Week07;

/*
给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

示例 1:

输入: 2
输出: [0,1,1]
示例 2:

输入: 5
输出: [0,1,1,2,1,2]

 */
public class Solution338 {

    public static int hammingWeight(int n) {

        int ret = 0;

        while (n != 0) {
            ret++;
            n &= (n - 1);
        }
        return ret;
    }

    public static int[] countBits(int num) {

        int[] ret = new int[num+1];
        for(int i=0; i<=num; i++){
            ret[i] = hammingWeight(i);
        }
        return ret;
    }

    public static void main(String[] args){
        int[] arr = countBits1(5);
        for(int item : arr){
            System.out.print(item+" ");
        }
    }

    static int[] countBits1(int num) {
        int[] ret = new int[num+1];
        ret[0] = 0;
        for(int i = 1; i <= num; i++)
        {
            if(i % 2 == 1)
            {
                ret[i] = ret[i-1] + 1;
            }
            else
            {
                ret[i] = ret[i/2];
            }
        }

        return ret;
    }
}
