public class Solution {
    public int ReversePairs(int[] nums) {
        if (nums == null) return 0;
        return ReversePairs(nums, new int[nums.Length], 0, nums.Length - 1);
    }

    private int ReversePairs(int[] nums, int[] tmp, int l, int r)
    {
        // terminator case: only one element
        if (l >= r) return 0;

        // Drill down
        int mid = (l + r) >> 1;
        // int mide = l + (r - l) / 2; In case l + r exceed the int.MaxValue.
        int left = ReversePairs(nums, tmp, l, mid);
        int right = ReversePairs(nums, tmp, mid + 1, r);
        int count = left + right;
        int t = l, i = l, c = l;
        for (int j = mid + 1; j <= r; j++)
        {
            // while (t <= mid && nums[t] <= (long)(2 * nums[j])) t++;
            while (t <= mid && nums[t] <= 2 * (long)nums[j]) t++;
            while (i <= mid && nums[i] <= nums[j]) tmp[c++] = nums[i++];
            tmp[c++] = nums[j];
            count += (mid + 1 - t); 
        }

       while (i <= mid) tmp[c++] = nums[i++];
       Array.Copy(tmp, l, nums, l, r - l + 1);
       return count;
    }
}