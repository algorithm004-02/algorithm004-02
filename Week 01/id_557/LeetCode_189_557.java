/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start

//First solution:
//Time Complexity: O(k*n)
//Space Complexity: O(1)

// class Solution {
//     public void rotate(int[] nums, int k) {
//         if (k < 0) {
//             return;
//         }
//         if (k % nums.length == 0) {
//             return;
//         }
//         k = k % nums.length;

//         for (int i = 0; i < k; i++) {
//             int temp = nums[nums.length - 1];
//             for (int j = nums.length - 2; j >= 0; j--) {
//                 nums[j + 1] = nums[j];
//             }
//             nums[0] = temp;

//         }

//     }
// }

//Second Solution:
//Time Complexity: O(n)
//Space Complexity: O(n)

// class Solution{
//     public void rotate(int[] nums,int k){
//         int[] newArray=new int[nums.length];
//         for(int i=0;i<nums.length;i++){
//             newArray[(i+k)%nums.length]=nums[i];
//         }
//         System.arraycopy(newArray,0,nums,0,newArray.length);
//     }
// }

//Third Solution:
//Time Complexity:O(n)
//Space Complexity:O(1)

// class Solution {
//     public void rotate(int[] nums, int k) {
//         int count = 0;
//         for (int start = 0; count < nums.length; start++) {
//             int current = start;
//             int prev = nums[start];
//             do {
//                 int next = (current + k) % nums.length;
//                 int temp = nums[next];
//                 nums[next] = prev;
//                 prev = temp;
//                 current = next;
//                 count++;
//             } while (start != current);
//         }
//     }
// }

//Fourth Solution:
//Time complexity:O(n)
//Space complexity:O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int nums[], int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
// @lc code=end
