public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String result = "";
        char[] arr = Integer.toBinaryString(n).toCharArray();

        for (int i = arr.length-1; i >=0 ; i--) {
            result += arr[i];
        }
        while (result.length()-32<0){
            result += '0';
        }
        return Integer.parseUnsignedInt(result,2);
    }
}