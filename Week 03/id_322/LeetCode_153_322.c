int findMin(int* nums, int numsSize){
    int i;
    int mimNum = 10000000;
    for (i = 0; i < numsSize; i++) {
        if (nums[i] < mimNum) {
            mimNum = nums[i];
        }
    }
    return mimNum;
}