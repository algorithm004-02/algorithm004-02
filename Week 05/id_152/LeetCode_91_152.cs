/*
    Intution:
        类似于爬楼梯，每次可以跳一步或者跳两步，不同的是，如果是大于26比如27则不行
        a. problem(i) = problem(i-1) + int.Parse(substring(i-1, i))<27?problem(i-2):0
        没有考虑current 为0的情况错了。
        b. 定义状态 dp(i)
        C. dp(i) = dp(i - 1) + int.Parse(substring(i-1, i) < 27) ? problem(i-2): 0

*/
public class Solution {
    public int NumDecodings(string s) {
        int prevous = 1;
        /* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        自己一开始没有考虑数字为0的情况，这点面试时需要和面试官说明的
        "1012" => 2
        "100" => 0
        ！！！！！！！！！！！！！！！！！！
        */
        if (int.Parse(s.Substring(0, 1)) == 0) return 0;
        int current = 1;
        for (int i = 1; i < s.Length; i++)
        {
            var tmp = current;
            int twoDigit = int.Parse(s.Substring(i - 1, 2));
            current = (int.Parse(s.Substring(i,1)) > 0 ? current : 0) + (twoDigit < 27 && twoDigit >= 10 ? prevous : 0);
            prevous = tmp;
        }

        return current;
    }
}