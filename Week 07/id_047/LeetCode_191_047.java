public class LeetCode_191_047 {
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for(int i = 0; i < 32; i ++) {
            int v = mask & n;
            System.out.println(v);
            if (v != 0) {
                count ++;
            }
            mask <<= 1;
        }
        return count;
    }
}
