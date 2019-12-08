package algorithm.LeetCode;

/**
 * describe:
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * @author lixilong
 * @date 2019/01/19
 */
public class _338_CountBits {

 //迭代统计1d的各式各样
  public int[] countBits(int num) {
    int arr[]= new int[num+1];
    for(int i = 0; i <=num; i++){
      int n=i;
      int count=0;
      while(n>0){
        n = n & (n - 1);
        count++;
      }
      arr[i]=count;
    }
    return arr;
  }


  //解法在此
  // https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/

  //迭代统计1d的各式各样
  public int[] countBits2(int num) {
    int arr[]= new int[num+1];
    for(int i = 0; i <=num; i++){
      arr[i] += arr[i & (i - 1)] + 1; //DP方程
    }
    return arr;
  }

}
