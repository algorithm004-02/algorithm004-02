//[153]寻找旋转排序数组中的最小值
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 你可以假设数组中不存在重复元素。 
//
// 示例 1: 
//
// 输入: [3,4,5,1,2]
//输出: 1 
//
// 示例 2: 
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0 
// Related Topics 数组 二分查找

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            if (nums[l] <= nums[r]) {
                return nums[l];
            }

            int mid = (l + r) / 2;
            if (nums[l] <= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        int result;
        int[] input;
        FindMinimumInRotatedSortedArray soluation = new FindMinimumInRotatedSortedArray();

        input = new int[]{1, 2, 3, 4, 5};
        for (int i = 1; i <= 5; i++) {
            System.arraycopy(input, 1, input, 0, 4);
            input[4] = i;
            result = soluation.findMin(input);
            System.out.println(result);
            if (result != 1) {
                throw new AssertionError("case1");
            }
        }

        input = new int[]{2, 3, 4, 5, 6,7};
        for (int i = 2; i <= 7; i++) {
            System.arraycopy(input, 1, input, 0, 5);
            input[5] = i;
            result = soluation.findMin(input);
            System.out.println(result);
            if (result != 2) {
                throw new AssertionError("case2");
            }
        }

        result = soluation.findMin(new int[] {3 ,5});
        System.out.println(result);
        if (result != 3) {
            throw new AssertionError("case3");
        }

        result = soluation.findMin(new int[] {5, 3});
        System.out.println(result);
        if (result != 3) {
            throw new AssertionError("case4");
        }

    }
}