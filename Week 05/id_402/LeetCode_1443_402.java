class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
    if(text1 == null || text2 == null || text1.length() == 0 || text2.length()==0){
               return 0;
           }
           int length1 = text1.length();
           int length2 = text2.length();
           int[][] arr = new int[length1 + 1][length2 + 1];
           for(int i = 1; i <= length1; i++)
               for(int j = 1; j <= length2; j++){
                      if(text1.charAt(i-1) == text2.charAt(j-1)){
                          arr[i][j] = arr[i-1][j-1] + 1;
                      } else{
                          arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                      }
               }
          return arr[length1][length2];
    }
}