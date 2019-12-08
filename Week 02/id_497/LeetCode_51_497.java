class Solution {
    List<List<String>> list = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        getQueen(n, new boolean[n], new boolean[n * 2 - 1], new boolean[n * 2 - 1], new LinkedList<>(), 0);
        return list;
    }

    public void getQueen(int n, boolean[] shu, boolean[] zuoxie, boolean[] youxie,
                         LinkedList<String> linkedList,
                         int index) {
        if (linkedList.size() == n) {
            list.add(new LinkedList<>(linkedList));
            return;
        }
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = '.';
        }

        for (int i = 0; i < n; i++) {
            if (shu[i] || youxie[n - 1 - index + i] || zuoxie[index + i]) continue;
            shu[i] = true;
            youxie[n - 1 - index + i] = true;
            zuoxie[index + i] = true;
            chars[i] = 'Q';
            linkedList.add(new String(chars));
            getQueen(n, shu, zuoxie, youxie, linkedList, index + 1);
            chars[i] = '.';
            linkedList.remove(index);
            shu[i] = false;
            youxie[n - 1 - index + i] = false;
            zuoxie[index + i] = false;
        }

    }
}