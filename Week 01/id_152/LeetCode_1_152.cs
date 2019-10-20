public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        
        var numIndexs=new Dictionary<int,int>();
        int index=0;
        foreach(int num in nums)
        {
            if(!numIndexs.ContainsKey(num))
            {
                numIndexs.Add(num,index);
            }
            else
            {
                if(num*2==target)
                {
                    return new int[]{numIndexs[num],index};
                }
            }
            
            
            var operand2=target-num;
            if(numIndexs.ContainsKey(operand2)&&numIndexs[operand2]!=index)
            {
                return new int[]{numIndexs[operand2],index};
            }
            
            index++;
        }
        throw new InvalidOperationException();
    }
}