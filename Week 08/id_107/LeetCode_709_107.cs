/*
    709. 转换成小写字母
    实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
*/

// 解法1: 暴力枚举+ASCII运算
// [a,z] = [97,122]
// [A,Z] = [65,90]

// 解法2: 利用位运算
// 大写变小写、小写变大写 : ASCII码 ^= 32
// 大写变小写、小写变小写 : ASCII码 |= 32
// 小写变大写、大写变大写 : ASCII码 &= -33
public class Solution {
    public string ToLowerCase(string str) {
        char[] charArray = str.ToCharArray();
        for(int i = 0; i< charArray.Length; i++)
        {
            char c = charArray[i];

            int newAsciValue = (int)c | 32;
            charArray[i] = (char)newAsciValue;
        }
        return new string(charArray);
    }
}