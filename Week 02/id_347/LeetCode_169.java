import java.util.HashMap;
class Solution {
    public int majorityElement(int[] nums) {
        //找出 数组长度 / 2 的临界值
        int times = nums.length / 2;
        //第一个Integer代表数字，第二个Integer代表是记录数字出现的次数
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            //不包含这个数，则这个数的出现次数时1
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                //包含这个数，则将这个数出现的次数 +1
                map.put(nums[i],map.get(nums[i]) + 1);
            }
        }
        for(Integer key : map.keySet()){
            //如果数字出现的次数 >  数组长度 / 2 的临界值,那么这个数就是题解，返回这个数字
            if(map.get(key) > times){
                return key;
            }
        }
        //找不到就返回 -1
        return -1;
    }
}
