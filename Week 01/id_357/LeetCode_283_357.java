public class Solution {
    //官方题解
    public void moveZerosOptimizition(int[] nums){
        int j = 0;
        int temp = 0;
        for(int i = 0; i <nums.length; i++){
            if (nums[i] != 0){
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] =temp;
                j++;

            }
        }
    }

    //自己的方法
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }

        System.out.println(j);

        for(int i = j; i < nums.length; i++){
            nums[i] = 0;
        }
    }

    public void printArray(int[] nums,int length){
        for (int i = 0; i < length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,1,3,0,0,0,9,8,7,0};
//        solution.moveZeroes(nums);
        solution.moveZerosOptimizition(nums);
        solution.printArray(nums,nums.length);
    }

}
