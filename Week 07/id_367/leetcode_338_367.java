class Solution {
    public int[] countBits(int num) {
        int a [] = new int [num+1];
        int i = 0;
        int count = 0;
        for( int k = 0;k < num+1; k++){
            int j = k;
            while(k!=0){
                //if((i & (i - 1))!=0)
                count++;
                //n = n & (n - 1);
                k = k & (k - 1);
            }
            a[j] = count;k = j; 
            count = 0;
        }
        return a;
    }
}
封装之后的代码
class Solution {
    public int[] countBits(int num) {
        int a [] = new int [num+1];
        int i = 0;
        for(;i<num+1;i++)
            a[i]=indSum(i);
        return a;
    }
    public int indSum(int k ){
        int count = 0;
            int j = k;
            while(k!=0){
                //if((i & (i - 1))!=0)
                count++;
                //n = n & (n - 1);
                k = k & (k - 1);
            }
            return count;
        }
        
    
}
//动态递推
class Solution {
    public int[] countBits(int num) {
        int ans [] = new int [num + 1];
        int i = 0,b = 1;
        while(b <= num){
            while(i<b&& i+b<=num){
                ans[i+b] = ans[i] +1;
                i++;
            }
            i = 0;
            b <<= 1;
        }
        return ans;
    }
}

//最简洁的代码
class Solution {
    public int[] countBits(int num) {
        int ans [] = new int [num + 1];
        //int[] ans = new int[num + 1];
      for (int i = 1; i <= num; ++i)
        ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
      return ans;


    }
}