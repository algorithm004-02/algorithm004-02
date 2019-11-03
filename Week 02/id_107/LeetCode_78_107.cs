/*
    78. 子集
    给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 */

// 解法 1:回溯
// 思路:
public class Solution
{
    List<IList<int>> result;

    public IList<IList<int>> Subsets(params int[] nums)
    {
        result = new List<IList<int>>();
        if (nums.Length == 0) return result;

        List<int> pre = new List<int>();
        Find(nums, 0, pre);

        return result;
    }

    public void Find(int[] nums, int begin, List<int> pre)
    {
        result.Add(new List<int>(pre));

        for (int i = begin; i < nums.Length; i++)
        {
            pre.Add(nums[i]);
            Find(nums, i + 1, pre);
            pre.RemoveAt(pre.Count - 1);
        }
    }

}