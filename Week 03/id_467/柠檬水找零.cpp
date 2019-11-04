class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        if (bills[0] != 5) return false;
        int five = 0, ten = 0, sum = 0;
        for (int i = 0; i < bills.size(); ++i) {
            if (bills[i] == 5) {
                sum += 5;   
                ++five;
            }
            else {
                if (sum < bills[i] - 5) return false;
                if (bills[i] == 10) {
                    if (five <= 0) return false;
                    --five;
                    ++ten;
                }
                else {
                    if (five > 0 && ten > 0) {
                        --five;
                        --ten;
                    } else if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                }
                sum += 5;
            }
        }
        return true;
    }
};