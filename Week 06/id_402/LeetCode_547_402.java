class Solution {//dfs
    public int findCircleNum(int[][] M) {
        HashMap<Integer, Integer> history = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (history.containsKey(i)) {
                continue;
            }
            count++;
            queue.add(i);
            history.put(i, 0);
            while (!queue.isEmpty()) {
                int top = queue.poll();
                for (int j = 0; j < M.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (M[top][j] == 0) {
                        continue;
                    }
                    if (!history.containsKey(j)) {
                        history.put(j, 0);
                        queue.add(j);
                    }
                }
            }
        }
        return count;
    }
}