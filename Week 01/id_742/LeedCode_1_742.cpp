class Solution {
public:
    int climbStairs(int n) {
        const double s = sqrt(5);
        return floor(pow((1+s)/2,n+1)/s + 0.5);
    }
};
