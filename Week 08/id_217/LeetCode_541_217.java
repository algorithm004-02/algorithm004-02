class Solution {
    public void rever(char[] s,int start,int end){
        char temp = '0';
        int high = end;
        for (int i = start; i <= (end + start) / 2; i++) {
            temp = s[i];
            s[i] = s[high];
            s[high] = temp;
            high--;
        }
    }

    public String reverseStr(String s, int k) {
        Solution solution = new Solution();
        char[] pop = s.toCharArray();
        int str = s.length();
        int nums = 0;
        if(k == 0){
            return s;
        }
        if(str == 0){
            return null;
        }

        int t = str / (2 * k);
        int q = str % (2 * k);
        for (int i = 0; i < t; i++) {
            solution.rever(pop, nums + 0, nums + k - 1);
            nums +=  + 2 * k;
        }
        if (q <= k) {
            solution.rever(pop, nums, nums + q - 1);
        } else {
            solution.rever(pop, nums, nums + k - 1);
        }
        String light = String.copyValueOf(pop);
        return light;
    }
}
