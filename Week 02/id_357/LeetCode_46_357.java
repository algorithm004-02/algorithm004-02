import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<List<Integer>> list = new ArrayList();

    public List<List<Integer>> permute(int[] nums) {
        travel(nums,0,nums.length);
        return list;
    }

    public void travel(int[] a, int level,int size){

        if (level >= size){
            List<Integer> temp = new ArrayList();
            printArray(a,temp);
            list.add(temp);
            return;
        }

        for(int i = level; i < size; i++){
            swap(a,level,i);
            travel(a,level+1,size);
            swap(a,level,i);
        }

    }

    public void printArray(int[] a,List<Integer> list){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
            list.add(a[i]);
        }
        System.out.println();
    }

    public void swap(int[] a,int i , int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        new Solution().permute(a);

    }
}