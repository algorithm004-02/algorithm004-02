public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0) System.arraycopy(nums2,0,nums1,0,nums2.length);
        if(n==0) return;
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1,0,nums1_copy,0,m);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n ){
            if(nums1_copy[i]<=nums2[j]) {
                nums1[k]=nums1_copy[i];
                i++;
                k++;
            }
            else {
                nums1[k] = nums2[j];
                j++;
                k++;
            }
        }
        if(i==m){
            System.arraycopy(nums2,j,nums1,k,nums2.length-j);
        }
        else if(j==n){
            System.arraycopy(nums1_copy,i,nums1,k,nums1_copy.length-i);
        }

    }