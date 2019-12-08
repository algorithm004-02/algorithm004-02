public class _153_findminimuminrotatedsortedarray {
    public static void main(String[] args) {
        ISolution s1 = new Solution1();
        int ans = s1.findMin(new int[] {3,4,5,1,2});
        System.out.println(ans);

        ans = s1.findMin(new int[] {4,5,6,7,0,1,2});
        System.out.println(ans);

        ISolution s2 = new Solution2();
        ans = s2.findMin(new int[] {3,4,5,1,2});
        System.out.println(ans);

        ans = s2.findMin(new int[] {4,5,6,7,0,1,2});
        System.out.println(ans);
    }
}

interface ISolution {
    int findMin(int[] nums);
}

/**
 * 二分法
 * time complexity : O(logN)
 */
class Solution1 implements ISolution {
    @Override
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length - 1;
        if (nums[0] < nums[right]) return nums[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid - 1] > nums[mid]) return nums[mid];
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Integer.MIN_VALUE;
    }
}

/**
 * 暴力法
 * time complexity : O(N)
 */
class
Solution2 implements ISolution {
    @Override
    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < ans) {
                ans = nums[i];
            }
        }
        return ans;
    }
}
