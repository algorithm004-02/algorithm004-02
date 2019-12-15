/*
  不要人肉递归，形成机器思维。先找出最小重复单元，定义其状态即状态转移方程，类似于generate parentheses那道题
  最优子结构的淘汰机制即左括号数要大于右括号数
  Intuition:
    最小单元是什么，一个parentheses长度增长只可能有两种情况
        1） （（（））），这种嵌套式的
        2） （）（）,这种串联式的
        嵌套式的可以通过右括号的indices减去左括号的indices as long as we have one left parentheses to match with the right one
        This means we have to store the indices of last available left parentheses. This reflectes first recusion relation(状态转移方程)
        which we can use a linked list implemented by an rrray which stores the last available left parentheses for the current element 
        of string. 这个思路解决了第一个问题。
        对于第二个基本情况，我们可以看出，左括号其实是带有信息值的，即第二种串联情况can only happens when the left parentheses is preceded
        by a  right parentheses.

  dp[i][2]定义一个二维数组，
  每一行第一个位置存上一个左括号的indices，第二个元素存当前位置的最大长度

  DP: 
    a. 子问题，
      1） 先对左括号进行更新
        对左括号的更新逻辑：
         1， 如果上一个是左括号，直接记录上一个indices
         2. 如果上一个是右括号，直接copy其记录的上一个左括号的值
         并在匹配后存储上上个左括号的值 ！！！
        对longest valid parentheses值的更新：
      2）
         1. 如果是右括号，知道会形成一个左右括号对了，所以看它有没有上一个indices,如果没有（值为-1),则什么都不做，
            如果有，则计算出来他和上一个match的左括号的距离 并且看上一个左括号位置记录的前面的相串联的前缀最大字符串长度
            by default, 值为0. 并把这个值记录下来。
         2. 如果是左括号，需要判断有没有前缀左右括号。即前面是不是右括号，如果是，右括号的存储的值。
    b. dp[i][0, 1] : dp[i][0]: 前缀最大字符串长度
                      dp[i][1]: 上一个左括号的indice
    c.
    // 从str的第二个元素出发。 
    1) if str[i - 1] == '('
        dp[i][0] = i - 1;
       else
        // have match
        dp[i][0] = dp[i - 1][0];

        2) if str[i] == '('
                if (str[i - 1] == ')' dp[i][1] = dp[i - 1][1];
           if str[i] == ')' && dp[i][0] != -1
            {
                // Find a match
                int match = dp[i][0];
                dp[i][1] = i - match + 1 +dp[match][1];
                dp[i][0] = dp[match][0];
            }

    Test Cases:
      1) ()
      2) ()()
      3) (()
      4) (()())
      5) ""
*/
public class Solution {
    public int LongestValidParentheses(string s) {
        int longest = 0;
        if (string.IsNullOrEmpty(s)) return longest;

        int[][] dp = new int[s.Length][];
        for (int i = 0; i < s.Length; i++)
        {
            dp[i] = new int[2];
            dp[i][0] = -1;
            dp[i][1] = 0;
        }

        for (int i = 1; i < s.Length; i++)
        {
            // step 1, update last left parenthesis indice
            if (s[i - 1] == '(')
            {
                dp[i][0] = i - 1;
            }
            else
            {
                dp[i][0] = dp[i - 1][0];
            }

            // step 2, update valid prentheses length and the longest 
            if (s[i] == '(' && s[i - 1] == ')') 
            {
                dp[i][1] = dp[i - 1][1];
            }
            if(s[i] == ')' && dp[i][0] != -1)
            {
                int matchLeftIndice = dp[i][0];
                dp[i][1] = i - matchLeftIndice + 1 + dp[matchLeftIndice][1];
                
                // update the longest
                // safe to do it only here. Because the valid parentheses always end here at right parenthesis position
                longest = Math.Max(longest, dp[i][1]);
                Console.WriteLine(longest);

                // Don't forget update the last available left parenthesis indice
                dp[i][0] = dp[matchLeftIndice][0];
                Console.WriteLine($"Indices: {dp[i][0]}");
            }
        }

        return longest;

    }
}