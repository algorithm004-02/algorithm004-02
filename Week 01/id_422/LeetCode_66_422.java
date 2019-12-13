class Solution{
  
    public int[] plusOne(int[] digits){
                
       for(int i =digits.length-1;i >= 0; i--){
            
            //加1 后%10 如果不等余 0 则是需要进一的情况  下次循环
           digits[i] ++;
           digits[i] = digits[i] % 10;

           if(digits[i] != 0){
              return digits;
           } 
       }
       
       // 如果每一位都是9  
       digits =new int[digits.length + 1];
       digits[0] = 1;
       return digits;
    }
}