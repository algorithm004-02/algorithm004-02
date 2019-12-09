public class LeetCode_26_657{


    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums);
    }


    public  static int removeDuplicates(int[] nums) {
    //    int m=0;
    //    int n=1;
    //     while(n < nums.length){
    //         if (nums[m] == nums[n]) {
    //             n++;
    //         } else {
    //             nums[++m]=nums[n];
    //         }
    //     }
    //     return m+1;


        int i=0,j=1;
        while(j < nums.length){
            if(nums[i] == nums[j])
            {
                j++;
            }
            else{
                nums[++i]=nums[j];
            }
        }
        return i+1;
    }

    
}