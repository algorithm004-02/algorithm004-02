//我的代码

class Solution {
    public boolean isPowerOfFour(int num) {
        int count = 1;
      if(num > 0 && ((num & (num - 1)) == 0)){
          if(num == 1)
            return true;
        while(num!=0){
            count++;
            num/=2;
        }
        if(count % 2 == 0) return true;
      }
      return false;
   }
}

//简洁代码
class Solution {
    public boolean isPowerOfFour(int num) {
         while ( (num != 0)  && (num % 4 == 0)) {
            num /= 4;
        }
        return num == 1;
    }
}
//与运算的代码
class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0)
			return false;
        //先判断是否是 2 的幂
		if ((num & num - 1) != 0)
			return false;
        //如果与运算之后是本身则是 4 的幂
		if ((num & 0x55555555) == num)
			return true;
		return false;
    }
}


