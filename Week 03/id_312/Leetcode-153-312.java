假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7]  可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

示例 1:

输入: [3,4,5,1,2]
输出: 1

示例 2:

输入: [4,5,6,7,0,1,2]
输出: 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//先判断是否为旋转的，若是则利用二分法找转折点
class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        //特殊情况
        if (nums.length <2||nums[0]<nums[hi]){
            return nums[0];
        }
        while (lo < hi){
            int mid = lo + (hi-lo)/2;
            if (nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            else if (nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            //向右规约
            else if (nums[lo]<nums[mid]){
                lo = mid + 1;
            }
            //想左规约
            else{
                hi = mid - 1;
            }       
        }
    return -1;
  }
}