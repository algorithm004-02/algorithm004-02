package datastruct.recur;

import java.util.*;

/**
 * 全排序
 */
public class QuanPaiLieByLeetcode {

    public static void main(String[] args) {
        int[] nums =  {1,2,3};

        QuanPaiLieByLeetcode quanPaiLieByLeetcode = new QuanPaiLieByLeetcode();
        System.out.println(quanPaiLieByLeetcode.permute(nums));
    }

    /**
     * 方法1：回溯法
        回溯法
            是一种通过探索所有可能的候选解来找出所有的解的算法。
            如果候选解被确认 不是 一个解的话（或者至少不是 最后一个 解），
            回溯算法会通过在上一步进行一些变化抛弃该解，即 回溯 并且再次尝试。

            这里有一个回溯函数，使用第一个整数的索引作为参数 backtrack(first)。

            如果第一个整数有索引 n，意味着当前排列已完成。
            遍历索引 first 到索引 n - 1 的所有整数。Iterate over the integers from index first to index n - 1.
            在排列中放置第 i 个整数，
            即 swap(nums[first], nums[i]).
            继续生成从第 i 个整数开始的所有排列: backtrack(first + 1).
            现在回溯，即通过 swap(nums[first], nums[i]) 还原.

     复杂性分析
     时间复杂度：\mathcal{O}(\sum_{k = 1}^{N}{P(N, k)})O(∑
     k=1
     N​
     P(N,k))， P(N, k) = \frac{N!}{(N - k)!} = N (N - 1) ... (N - k + 1)P(N,k)=
     (N−k)!N!=N(N−1)...(N−k+1)，该式被称作 n 的 k-排列，或者_部分排列_.

     *
     *
     *
     */
        public void backtrack(int n, ArrayList<Integer> nums
                ,List<List<Integer>> output,int first) {
            // if all intergers are used up
            if (first == n)
                output.add(new ArrayList<Integer>(nums));

            for (int i = first;i < n; i++) {
                // place i-th integer first
                // in the current permutation
                Collections.swap(nums,first,i);
                // user next intergers to complete the permutations
                backtrack(n,nums,output,first +1);
            }
        }

        public List<List<Integer>> permute(int[] nums) {
            // init output list
            List<List<Integer>> output = new LinkedList<>();

            // convert nums to list since the output is a list of lists
//            ArrayList<Integer> nums_lit = new ArrayList<>();
//            for (int num : nums)
//                nums_lit.add(num);
//
//            int n = nums.length;
            //backtrack(n,nums_lit,output,0);
            int[] visited = new int[nums.length];
            backtrack1(output,nums,new ArrayList<>(),visited);
            return output;
        }

    private void backtrack1(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack1(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

}
