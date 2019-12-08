// https://leetcode-cn.com/problems/move-zeroes/

// 1 暴力法
// a 创建一个新的array
// b 遍历original array，将不为0的元素拷贝到新的array中
// c 将新array的剩余位置，用0补全
// d 将新array中的元素再拷贝回旧array
// 总结：此暴力方法适用了三次for循环，第一次pick非0的元素复杂度O(N)，第二次，新array空位补0复杂度O(N)，第三次，拷贝回旧的array复杂度O(N)
// 所以最终的复杂度是O(N)。而且由于新数组的创建，导致空间复杂度也是O(N)
class Solution {
    public void moveZeroes(int[] nums) {
        int[] newArray = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                newArray[j++] = nums[i];
            }
        }
        for (;j < nums.length; j++) {
            newArray[j] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArray[i];
        }
    }
}

//2 双指针法，一个指针i指向数组当前位置，一个指针j指向下一个非0元素应该填入的位置
// 遍历数组：
//  1 当i位置元素不为0时，将i位置的元素填入j的位置
//      a 如果i与j不相等，将i位置置为0
//    然后更新i++，j++
//  2 当元素为0时，不执行交换，只更新i++

class Solution2 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        for (; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) { //这个判断表示这是否是一个与0的交换位置操作
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}

// 3 count zero法
// 1 用一个变量offset来记录在一个非0元素之前，有多少个0。其实该变量表示的就是当前元素与它该填充位置的offset

class Solution3 {
    public void moveZeroes(int[] nums) {
        int offset = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                offset++;
                continue;
            }
            if (nums[i] != 0 && offset != 0) {
                nums[i - offset] = nums[i];
                nums[i] = 0;
            }
            
        }
    }
}