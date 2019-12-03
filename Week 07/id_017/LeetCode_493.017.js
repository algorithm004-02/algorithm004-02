
/**
 * 493.翻转对 参考别人
 * @param {number[]} nums
 * @return {number}
 */
var reversePairs = function(nums) {
    let count = 0;
    let mergeArr = (arr,left,mid,right) => {
        let temp = [];
        let i = left,j = mid + 1,sortedIndex = 0,p = j;
        let tmpI = i,tmpJ = j;
        while(tmpI <= mid){
            while(tmpJ <= right && arr[tmpI]/2 > arr[tmpJ]){
                tmpJ++;
            }
            count += tmpJ - (mid + 1);
            tmpI++;
        }
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[sortedIndex++] = arr[i++];
            }else{
                temp[sortedIndex++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[sortedIndex++] = arr[i++];
        }
        while(j <= right){
            temp[sortedIndex++] = arr[j++];
        }
        for(let r = 0;r < temp.length;r++){
            arr[left + r] = temp[r];
        }
    }
    let mergeSort = (arr,left,right) => {
        if(left >= right){
            return;
        }
        let mid = (left + right) >> 1;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        mergeArr(arr,left,mid,right);
    }
    mergeSort(nums,0,nums.length-1);
    return count;
};
