/**
 * @(#)RemoveDuplicatesFromSortedArray.java, Oct 16, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/**
 * 题目：给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 题解：
 * 1.开辟一个新的数组，遍历数组，取出不重复元素放入新的数组，最后将新的数组拷贝到原数组，
 *   时间复杂度：O(n),空间复杂度：O(n),题目明确要求空间复杂度O(1)   --> pass
 * 2.我们可以在之前的思路上优化一下：直接在原数组上找一块空间来存去重后的数据，空间附加度O(1)，时间复杂度O(n)
 *   我们可以利用两个指针i，j将数组分成三个部分，[0，i]没有重复元素的部分，也就是我们最终的结果，[i+1,j]已知的重复元素所在的部分，
 *   [j+1,length-1]未处理元素的部分，也就是我们还没遍历的部分，利用j不断遍历数组，每遍历一个元素我们就和[0,i]的最后一个元素比较一下，如果相等我们
 *   j++把它扔到[i+1,j]这个部分就好了，如果不相等，我们把他扔到[0,i]这个区间就好了，也就是nums[i+1] = nums[j],i++.    ----->这种方法可行主要是因为数组本身有序
 *
 */

/**
 * @author helloliu
 */
public class RemoveDuplicatesFromSortedArray {

    public int solution(int[] nums) {

        if (nums.length <= 0) {
            return 0;
        }

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }

}
