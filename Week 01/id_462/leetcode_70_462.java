class Solution {
    public int climbStairs(int n) {
        if(n<=3){
            return n;
        }
        int l1 =1;
        int l2= 2;
        int l3 =3;

        for (int i=4;i<=n;i++) {
            l1=l2;
            l2=l3;
            l3=l1+l2;
        }
        return l3;
    }
}