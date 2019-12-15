public class Solution {
	public String reverseStr(String s, int k) {
		char[] arr = s.toCharArray();
	    for(int i = 0;i < arr.length;){
	        if(i + k >= arr.length){
	            reverseArr(arr,i,arr.length - 1);
	            break;
	        }else{
	            reverseArr(arr,i,i + k-1);
	        }
	        i += k;
	        if(i + k >= arr.length){
	            break;
	        }
	        i += k;
	    }
	    return String.valueOf(arr);
        
    }
	
	public void reverseArr(char[] arr , int from , int end){
	    for(int i = from , j = end; i < j;i++ , j--){
	        char t = arr[i];
	        arr[i] = arr[j];
	        arr[j] = t;
	    }

	}
}