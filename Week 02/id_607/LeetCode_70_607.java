class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f2 + f1;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
    
}

//找重复性，
//找规律,f3=f2+f1,每次记录f1,f2很快算出f3,然后更新f1,f2,