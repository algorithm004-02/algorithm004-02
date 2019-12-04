class Solution {
    public int findCircleNum(int[][] M) {
        int[] parents = new int[M.length];
        int count = 0;
        Arrays.fill(parents,-1);
        for (int i = 0; i <M.length ; i++) {
            for (int j = 0; j < M.length; j++) {
                if(M[i][j]==1&&i!=j){
                    union(parents,i,j);
                }
            }
        }

        for (int i = 0; i < parents.length ; i++) {
            if(parents[i]==-1){
                count++;
            }
        }
        return count;
    }

    private void union(int[] parents, int i, int j) {
        int xset = find(parents,i);
        int yset = find(parents,j);
        if(xset!=yset){
            parents[xset] = yset;
        }
    }

    private int find(int[] parents, int i) {
        if(parents[i]==-1){
            return i;
        }
        return find(parents,parents[i]);
    }
}