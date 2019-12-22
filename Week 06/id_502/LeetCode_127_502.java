class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList.size());
        wordSet.addAll(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        s1.add(beginWord);
        s2.add(endWord);
        int n = beginWord.length();
        int step = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            step++;
            if (s1.size() > s2.size()) {
                Set<String> tmp = s1;
                s1 = s2;
                s2 = tmp;
            }
            Set<String> s = new HashSet<>();
            for (String word : s1) {
                for (int i = 0; i < n; i++) {
                    char[] chars = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String tmp = new String(chars);
                        if (s2.contains(tmp)) return step + 1;
                        if (!wordSet.contains(tmp)) continue;
                        wordSet.remove(tmp);
                        s.add(tmp);
                    }
                }
            }
            s1 = s;
        }
        return 0;        
    }
}