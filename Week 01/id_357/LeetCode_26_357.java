/**
 * Leetcode-26
 */
class Solution {

    //讨论区看到的优化解法：双指针法
    public int removeDuplicatesOptimizition(int[] nums){
        int j = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[j]){
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    //自己的方法
    public int removeDuplicates(int[] nums) {
        int newLength = 1;
        for (int i = nums.length - 1; i > 0; i--){
            if (nums[i] == nums[i - 1]){
                System.arraycopy(nums,i,nums,i-1,nums.length - i);
            }else{
                newLength ++;
            }
        }
        System.out.println(newLength);
        return newLength;
    }

    public void printArray(int[] nums,int length){
        for (int i = 0; i < length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,2,2,4,5};
//        int length = solution.removeDuplicates(nums);
        int length = solution.removeDuplicatesOptimizition(nums);
        solution.printArray(nums,length);


        int[] nums1 = {2,2,3,3,4};
//        length = solution.removeDuplicates(nums1);
        length = solution.removeDuplicatesOptimizition(nums1);
        solution.printArray(nums1,length);

        int[] nums2 = {1,2,3,3,3};
        length = solution.removeDuplicatesOptimizition(nums2);
        solution.printArray(nums2,length);

    }
}