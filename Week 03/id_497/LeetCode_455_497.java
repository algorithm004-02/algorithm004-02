class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int a = g[0];
        int index = 0;
        int count =0;
        for (int i = 0; i < s.length; i++) {
            if(a<=s[i]){
                count++;
                index++;
                if(g.length==index){
                    break;
                }
                a = g[index];

            }

        }

        return count;
    }

}