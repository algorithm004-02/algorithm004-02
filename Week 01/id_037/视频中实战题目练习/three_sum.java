import java.util.List;

// https://leetcode-cn.com/problems/3sum/
// 1暴力法 遍历

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        if (nums == null || nums.length < 3) return ans;
        for (int i = 0; i < nums.length -2 ; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ans.add(Arrays.asList(i, j, k));
                    }
                }
            }
        }
        return ans;
    }
}

// 排序数组，双指针
// a 将数组从小到大排序 O（N）
// b 遍历数组每次取 nums[k], 如果nums[k]>0,直接break。然后固定双指针i，j在(k, nums.length)的两端，可以看到nums[k]将是三个数中最小的
//     只要i!=j, 则计算s = nums[k] + nums[i] + nums[j]
//         如果s<0, 那么移动i向内部，即i++，移动过程中跳过num[i+1] = num[i]
//         如果s>0, 那么移动j向内部，即j--,移动过程中跳过num[j-1] = nump[j]
//         如果s==0，将此次结果如list，同时 i++,j--,移动过程中跳过num[i+1] = num[i]，num[j-1] = nump[j]
class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List ans = new ArrayList();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break; //k位置已经大于0，往后只会越来越大，所以直接跳出
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1;
            int j = nums.length - 1;
            int sum = 0;
            while (i < j) {
                sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]); //一步搞定是否重复并且自增
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]);
                } else {
                    ans.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return ans;
    }
}