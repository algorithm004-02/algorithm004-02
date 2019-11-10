class Solution {
    //33. 搜索旋转排序数组
    //二分查找
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = lo + (hi - lo) / 2;
        
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            //当[0,mid]有序时,向后规约条件
            if (nums[0] <= nums[mid] 
                && (target > nums[mid] || target < nums[0])) {
                lo = mid + 1;
            } else if (target > nums[mid] && target < nums[0]) { 
                //当[0,mid]发生旋转时，向后规约条件
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }
}