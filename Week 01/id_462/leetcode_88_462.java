class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //先把nums1中的数组拷贝出来
        int[] tempnums1 = new int[m];
        for(int i=0;i<m;i++){
            tempnums1[i] = nums1[i];
        }

        int p=0,q=0,writeIndex = 0;
        while(p<m && q<n ){
            if(tempnums1[p]<=nums2[q]){
                nums1[writeIndex]=tempnums1[p++];
            }else{
                nums1[writeIndex]=nums2[q++];
            }
            writeIndex++;
        }
        if(p<m){
            for(;p<m;p++){
                nums1[writeIndex]=tempnums1[p];
                writeIndex++;
            }
        }
        if(q<n){
            for(;q<n;q++){
                nums1[writeIndex]=nums2[q];
                writeIndex++;
            }
        }
    }
}