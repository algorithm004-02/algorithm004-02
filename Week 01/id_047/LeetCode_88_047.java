public class LeetCode_88_047 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m + n > nums1.length) {
            return;
        }

        int currLength = m;
        int left = 0;
        for (int i = 0; i < n; i++) {
            int aNumber = nums2[i];

            int position = findInsertPosition(nums1, currLength, left, aNumber);
            left = position;

            insert(nums1, currLength, aNumber, position);

            ++currLength;
        }
    }


    //二分查找
    private static int findInsertPosition(int[] nums, int n, int left, int value) {
        int right = n - 1;
        if (nums[left] > value) {
            return left;
        } else if (nums[left] == value) {
            return left + 1;
        }
        if (nums[right] <= value) {
            return right + 1;
        }

        int middle = (left + right) >> 1;
        while (middle > left && middle < right) {
            if (nums[middle] > value) {
                right = middle;
            } else if (nums[middle] < value) {
                left = middle;
            } else {
                return middle + 1;
            }
            middle = (left + right) >> 1;
        }
        if (nums[right] == value) {
            return right + 1;
        }

        return left + 1;
    }

    //插入元素
    private static void insert(int[] nums, int len, int insertVal, int insertPosition) {
        for (int i = len - 1; i >= insertPosition; i--) {
            nums[i + 1] = nums[i];
        }
        nums[insertPosition] = insertVal;
    }
}