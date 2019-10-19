public class LeetCode_189_047 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int head = k % n;
        if (head == 0) {
            return;
        }

        int[] temp = new int[head];

        for (int i = 0; i < head; i++) {
            temp[i] = nums[n - head + i];
        }

        for (int i = n - 1 - head; i >= 0; i--) {
            nums[i + head] = nums[i];
        }

        for (int i = 0; i < head; i++) {
            nums[i] = temp[i];
        }
    }
}