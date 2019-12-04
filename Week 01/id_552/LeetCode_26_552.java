package Week01;

public class RemoveDuplicates {

    /**
     * 添加双指针，将数组中重复元素替换为MAX_VALUE
     */
    public static int replaceDuplicates(int[] nums) {

        //index为数组索引，next为当前index+1的位置
        int index = 0, next = 1, count = 1;
        while(index < nums.length && next < nums.length){

            if(nums[index] == nums[next]){
                //重复元素置为max
                nums[next] = Integer.MAX_VALUE;
                //如果索引index和索引index+1相等，next++
                next++;
            }else{

                //不相等，index赋值为next值，开始一个新值的比较
                index = next;
                next++;
                count++;

            }
        }
        //返回数组中不重复元素个数
        return count;

    }

    public static void main(String args[]) {

        int[] arr = {0,0,1,1,2,2,3,3,4,4,4,5};
        //int sum = replaceDuplicates(arr);


        /* 按照例子中的数组，arr经过replaceDuplicates变为
        {0,MAX_VALUE,1,MAX_VALUE,2,MAX_VALUE,3,MAX_VALUE,4,MAX_VALUE,MAX_VALUE,5} */

        //然后对sum进行排序，这样变为{0,1,2,3,4,5,MAX_VALUE,MAX_VALUE,MAX_VALUE,MAX_VALUE,MAX_VALUE,MAX_VALUE}
        //但是，总的时间复杂度为O(N)+O(NlogN)，而且加入排序方法后，代码变得比较多
        //所以，还是比较挫的一个解法，没有一步到位。但这个方法是我掐表第一直觉写出来的，所以就直接作为答案提交了，
        // 接下来，会比较比较好的解法，想一下为什么没有一步到位。
    }
}
