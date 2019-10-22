
    public int trap2(int[] height) {
        int sum = 0;
        int size = height.length;
        for(int i = 1;i < size - 1 ;i++){
            int leftmax = 0,rightmax = 0;
            for(int j = i;j >= 0;--j){
                leftmax = Math.max(leftmax,height[j]);
            }
            for(int j = i;j < size;++j) {
                rightmax = Math.max(rightmax,height[j]);
            }
            sum += Math.min(leftmax,rightmax) - height[i];
        }
        return sum;
    }