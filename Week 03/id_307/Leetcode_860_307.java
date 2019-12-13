class Solution {
    // 5: 0, 10: 0, 20: 0
    private int[] wallet = {0, 0, 0};
    public boolean lemonadeChange(int[] bills) {
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                wallet[0]++;
            }
            if (bills[i] == 10) {
                wallet[0]--;
                wallet[1]++;
            }
            // 1. back 10 and 5
            // 2. back 3 times of 5
            if (bills[i] == 20) {
                wallet[2]++;
                if (wallet[1] == 0) {
                    wallet[0] -= 3;
                } else {
                    wallet[1]--;
                    wallet[0]--;
                }
            }
            if (wallet[0] < 0 || wallet[1] < 0 || wallet[2] < 0) {
                return false;
            }
        }
        return true;
    }
}