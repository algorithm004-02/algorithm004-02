/* 
* 题号: 860
* 题目: 柠檬水找零
* 地址: https://leetcode-cn.com/problems/lemonade-change/
*/

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int i = 0,j = 0,k =0;
        for(int s = 0; s < bills.length; s++){
            if(5 == bills[s]){
                i++;
            }else if(10 == bills[s]){
                i--;
                j++;
            }else if(20 == bills[s]){
                if(j > 0){
                    j--;
                    i--;
                    k++;
                }else {
                    i -= 3;
                }
            }
            if(i < 0 || j < 0 || k < 0) return false;
        }
        return true;
    }
}
