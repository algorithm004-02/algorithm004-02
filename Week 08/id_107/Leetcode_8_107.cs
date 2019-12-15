/*
    8. 字符串转换整数 (atoi)
    请你来实现一个 atoi 函数，使其能将字符串转换成整数。
*/

public class Solution {
    public int MyAtoi(string str) {
        if(string.IsNullOrWhiteSpace(str)) return 0;

        var numBuilder = new StringBuilder(16);
        var numList = new LinkedList<char>();
        foreach(char c in str)
        {
            if(c == ' ') continue;

            // 
            if(numList.Count == 0)
            {
                if(!char.IsNumber(c) && c != '-') break;

                numList.AddLast(c);
                numBuilder.Append(c);
            }
            else
            {
                if(char.IsNumber(c) && char.IsNumber(numList.Last.Value))
                {
                    numList.AddLast(c);
                    numBuilder.Append(c);
                }
                else
                {
                    break;
                }
            }
        }

        int value = Convert.ToInt32(numBuilder.ToString());
        if(value >= int.MinValue && value <= int.MaxValue)
        {
            return value;
        }

        return 0;
    }
}