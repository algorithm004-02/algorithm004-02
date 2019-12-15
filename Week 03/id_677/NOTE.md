# NOTE

## Question
```
使用二分查找，寻找一个半有序数组[4, 5, 6, 7, 0, 1, 2]中间无序的地方
说明：同学们可以将自己的思路、代码写在第3周的学习总结中
```  

## 解题思路(切题四件套)

#### 1. clarification
- 明确规定使用二分查找，最后的题解需要用二分法实现
- 其他实现方式，可以提出思路，参考对比
- 半有序，意味着中间有断层,属于//型或者\\型,注意同 前半部分与后半部分排序不一致的区别，如前半部分升序后半部分降序，或者前半部分降序后半部分升序，属于V型结构
- 根据样例数据，排序规则为升序，故数据属于//型
- 根据样例数据，无重复元素，具体实现时，是否可以给出通用实现(即兼容存在重复元素的情况)
- 二分查找的时间复杂度为O(logN)
- 返回值为数据无序处的下标

#### 2. possible solutions
- 暴力法，顺序迭代发现断层即为无序处，舍弃
- 没有重复元素时
- 存在重复元素时
- 二分时，当前数组切片的首元素是核心参考依据

#### 3. coding
```
class Solution {
    public int findDisorder(int[] nums) {
       if (nums == null || nums.length <= 2) return -1; 
       int left = 0;
       int right = nums.length - 1;
       while (left < right) {
           int mid = left + (right - left) / 2;
           if (nums[mid - 1] > nums[mid]) return mid;
           if (nums[mid] > nums[mid + 1]) return mid + 1;
           if (nums[mid] > nums[0]) {
               left = mid + 1;
           } else {
               right = mid - 1;
           }
       }
       return -1;
    }
}
```

#### 4. test cases
- [4,5,6,7,0,1,2] return 4;
- [1,2,3,4,5,6,7] return -1;
- [2,3,4,5,6,7,1] return 6;
- [1,2,3,4,4,4,6] return -1; // duplicate items
- [2,3,3,4,4,6,1] return 6; // duplicate items

#### PS: 个人总结
一定要注意边界条件,否则可能会出现下标越界BUG
