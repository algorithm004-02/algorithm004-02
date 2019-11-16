class Solution {
    
    public int search(int[] nums, int target) {
     
       /* int start = 0;
        int end = nums.length - 1; 
    //找出最小值的数组下标
   /* while (start < end) {
        int mid = (start + end) / 2;  
        if (nums[mid] > nums[end]) {
            start = mid + 1  ;
        } else {
            end = mid;
        }
    } 
    int bias = start;*/
    //找出最大值的数组下标
    /*while (start < end) {
        int mid = Math.round(((float)start + end) / 2); 
        if (nums[mid] < nums[start]) {
            end = mid - 1;
        } else {
            start = mid;
        }

    } 
  /*  int n = nums.length;
    int bias = (start + n)  - (n - 1); //得到偏移
    start = 0;
    end = nums.length - 1;
    while (start <= end) {
        int mid = (start + end) / 2;//中间的位置 
        int mid_change = (mid + bias) % nums.length;//中间的位置对应的数组下标
        int value = nums[mid_change];//中间位置的值
        if (target == value) {
            return mid_change;
        }
        if (target < value) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    return -1;

//官方解法有问题
        
    }*/
        int lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        int num = nums[mid]; 
        //nums [ mid ] 和 target 在同一段
        if ((nums[mid] < nums[0]) == (target < nums[0])) {    //同为ture或同为false成立
            num = nums[mid];
        //nums [ mid ] 和 target 不在同一段，同时还要考虑下变成 -inf 还是 inf。
        } else {
            num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        if (num < target)
            lo = mid + 1;
        else if (num > target)
            hi = mid - 1;
        else
            return mid;
    }
    return -1;
    }

}