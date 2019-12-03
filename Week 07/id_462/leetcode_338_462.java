/**
 * 比特位计数
 */
class Solution {
    public int[] countBits(int num) {
        int[] n = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            if(i == 0) {
                n[i] = 0;
                continue;
            }
            //奇数,一定比最低位的偶数多一个1
            if((i & 1) == 1){
                n[i] = n[i - 1] + 1;
            }else{
                //偶数，位1的个数一定比他一半的那个数位1的个数一样
                n[i] = n[i/2];
            }
        }
        return n;
    }
}