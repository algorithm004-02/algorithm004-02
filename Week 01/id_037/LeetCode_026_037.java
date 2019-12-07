// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
// 双指针，时间复杂度O(N)
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int size = 0;
        int k = 0; 
        for (int i = 0, j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) { // 此时i与j-1之间是重复的数字
                //在k处填入i处的数字，然后将i更新到j
                nums[k++] = nums[i];
                i = j;
                size++;
            }
        }
        //以上循环后，我们把最后一个元素填入到k的位置，并且size+1
        nums[k] = nums[nums.length - 1];
        return size + 1;
    }
}

//2 上阶梯法 时间复杂度O(N)
// 利用题目中给的条件，数组是被排好序的。所以，每次发现元素变大，就说明有了一个不同的元素.就像我们上了一次台阶
class Solution2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int start = Integer.MIN_VALUE;
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > start) {
                nums[size++] = nums[i];
                start = nums[i];
            }
        }
        return size;
    }
}
//3 利用set 时间复杂度O(N^2).因为set在查找时复杂度O(N)
class Solution3 {
    public int removeDuplicates(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!unique.contains(nums[i])) {
                unique.add(nums[i]);
                nums[size++] = nums[i];
            }
        }
        return size;
    }
}