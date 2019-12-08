// https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/

public class Solution {
    public int findMin(int[] num) {
        int low = 0;
        int high = num.length - 1;
        while(low < high){
            int mid = (low + high) / 2;
            if(num[high] < num[mid]){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return num[high];
    }
}