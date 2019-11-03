// 使用 双端队列 Deque 解此问题
class Solution {
    private ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
    private int[] nums;

    public void clean_deque(int i, int k) {
        if (!(deque.isEmpty()) && deque.getFirst() == i-k) {
            deque.removeFirst();
        }

        while (!(deque.isEmpty()) && (nums[i] > nums[deque.getLast()])) {
            deque.removeLast();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //n或k有一个是0，则返加一个空数组
        if (n*k==0) return new int[0];
        //k==1时，返回传入参数 nums本身
        if (k==1) return nums;

        this.nums = nums;
        int max_index = 0;
        for (int i=0; i<k; i++) {
            //清空双端队列 deque
            clean_deque(i, k);
            deque.addLast(i);
            if (nums[i] > nums[max_index]) max_index = i;
        }
        int[] output = new int[n-k+1];
        output[0] = nums[max_index];
        for (int i = k; i < n; i++) {
            //清空双端队列 deque
            clean_deque(i, k);
            deque.addLast(i);
            output[i-k+1] = nums[deque.getFirst()];
        }
        return output;
    }

}