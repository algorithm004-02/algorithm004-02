package main.java.com.fans.algorithm00402.week1.homework;

/*
* 【---------删除排序数组中的重复项---------】
* 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

示例 1:

给定数组 nums = [1,1,2],

函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

你不需要考虑数组中超出新长度后面的元素。
示例 2:

给定 nums = [0,0,1,1,1,2,2,3,3,4],

函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

你不需要考虑数组中超出新长度后面的元素。
说明:

为什么返回数值是整数，但输出的答案是数组呢?

请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

你可以想象内部操作如下:

// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
*
*
*
*
*
* */

import java.util.HashMap;

public class LeetCode_26_232 {

    public static void main(String[] args) {
        LeetCode_26_232 code = new LeetCode_26_232();
        int res = code.removeDuplicates(new int[]{1,1});
        System.out.println(res);
    }

    // 1. 利用hash保存出现的元素, 把所有重复的元素值给成一个大于最大数的数， 移动这个数  时：O(n)  空：O(n)
//    public int removeDuplicates(int[] nums) {
//        if (nums.length < 2) return nums.length;
//        int tag = nums[nums.length - 1] + 1;
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int i = 0 ; i < nums.length ; i ++) {
//            if (hashMap.get(nums[i]) != null) nums[i] = tag;
//            hashMap.put(nums[i], i);
//        }
//
//        int k = 0;
//        for (int i = 0 ; i < nums.length ; i ++) {
//            if (nums[i] != tag) {
//                nums[k ++] = nums[i];
//            } else {
//                if (i != k) {
//                    nums[i] = tag;
//                }
//            }
//        }
//
//        return k;
//    }

    // 2. 双指针法   时：O(n)  空：O(1)
//    public int removeDuplicates(int[] nums) {
//        if (nums.length < 2) return nums.length;
//        int left = 0;
//        int right = 0;
//
//        while (right < nums.length) {
//            // right找到一个 位置 nums[left] != nums[right]
//            while (right < nums.length && nums[left] == nums[right]) right ++;
//
//            if (right >= nums.length) break;
//            // 找到了一个right
//            left ++;
//            int temp = nums[left];
//            nums[left] = nums[right];
//            nums[right] = temp;
//
//            right ++;
//        }
//
//        return left + 1;
//    }

    // 3. 优美的双指针 （上面的代码我写了交换， 其实这里不需要交换）   时：O(n)  空：O(1)
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;

        int i = 0;
        for (int j = 1; j < nums.length; j ++) {
            if (nums[j] != nums[i]) {
                i ++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
