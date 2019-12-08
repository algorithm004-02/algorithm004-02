class Solution {
    public boolean lemonadeChange(int[] bills) {
        // 20、10 需要 5、10的来找零。则需要保存5、10的数量
        int five = 0, ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five > 0) {
                    five--;
                } else {
                    return false;
                }
                ten++;
            } else { // 20
                if (ten > 0) {//有10，则必须有10+5才能找零
                    ten--;
                    if (five > 0) {
                        five--;
                    } else {
                        return false;
                    }
                } else {//只有5，必须则必须有3*5才能找零
                    if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}