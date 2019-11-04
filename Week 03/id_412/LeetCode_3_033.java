package Week03.Chapter11;

public class LeetCode_3_033 {
    // https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
    // nums[0] <= nums[mid]--> 左边升序 --> target > nums[mid] || target < nums[0] -->向后规约
    // nums[0] > nums[mid]--> 左边存在旋转位 --> target < nums[0] && target > nums[mid] -->向后规约
    // [0,1,2,4,5,6,7] --> [2,4,5,6,7,0,1]
    // [0,1,2,4,5,6] -->   [4,5,6,0,1,2]
    // [0,1,2,4,5,6,7] --> [6,7,0,1,2,4,5]
    private int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            // 左边升序 : 左边部分数据为 [nums[lo],nums[mid])
            System.out.printf("nums[0]=%d,lo=%d,mid=%d,hi=%d,nums[mid]=%d,nums[hi]=%d\n",nums[0],lo,mid,hi,nums[mid],nums[hi]);
            if (nums[lo] <= nums[mid] && (target > nums[mid] || target < nums[lo])) {
                lo = mid + 1;
            // 右边升序 : 右边部分数据为 (nums[mid], nums[lo]) 之间
            } else if (target > nums[mid] && target < nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }

    // O(log n)
    private int findRotateIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int left = 0, right = nums.length - 1;

        if (nums[right] >= nums[0]) {
            return 0;
        }

        while (right > left) {
            int mid = (right + left)/ 2;
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }
            if (nums[mid - 1] > nums[mid]) {
                return mid;
            }

            if (nums[mid] > nums[left]) {
                // 往右边找
                left = mid + 1;
            } else {
                // 往左边找
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        final int[] nums = {2,3,4,5,6,7,8,0,1};
        final LeetCode_3_033 test = new LeetCode_3_033();
        System.out.printf("%d\n",test.search(nums,4));
        System.out.println(test.findRotateIndex(nums));
    }

}
