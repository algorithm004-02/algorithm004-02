package com.company;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static int count = 0;
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();  //定义ans
        count++;
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; c++)
                for (String left: generateParenthesis(c)) {  //进行for each 循环
                    for (String right: generateParenthesis(n-1-c))
                        ans.add( left +"("+ right+  ")" );
                }
        }
        return ans;
    }
    public int getCount(){
        return count;
    }
}
public class Main {

    public static void main(String[] args) {

        Solution s = new Solution();
        List<String> ans = new ArrayList<>();
        ans = s.generateParenthesis(2);
        System.out.println(ans);
        System.out.println(s.getCount());
	// write your code here
    }
}