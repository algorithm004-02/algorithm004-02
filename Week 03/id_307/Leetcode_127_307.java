//深度
//广度会好写一点
class Solution {
    class Situation implements Cloneable {
        int length;
        String beginWord;
        String endWord;
        
        public Situation clone() {
            try {
                return (Situation) super.clone();   
            } catch (Exception e) {
                return null;
            }
        }
    }
    

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Boolean> occupied = new HashMap<>();
        wordList.forEach((word) -> {
           for (int i = 0; i < word.length(); i++) {
               String genericWord = String.format("%s-%s", word.substring(0, i), word.substring(i + 1, word.length()));
               List<String> relativeWords = map.getOrDefault(genericWord, new ArrayList<>());
               relativeWords.add(word);
               map.put(genericWord, relativeWords);
           } 
        });
        Deque<Situation> deque = new LinkedList<>();
        Situation s = new Situation();
        s.length = 1;
        s.beginWord = beginWord;
        s.endWord = beginWord;
        deque.addLast(s);
        occupied.put(beginWord, true);
        while (!deque.isEmpty()) {
            s = deque.removeFirst();
            String lastWord = s.endWord;
            for (int i = 0; i < lastWord.length(); i++) {
                String genericWord = String.format("%s-%s", lastWord.substring(0, i), lastWord.substring(i + 1, lastWord.length()));
                List<String> relativeWords = map.get(genericWord);
                // 字典中没有，忽略这个通用的组合
                if (relativeWords == null ) {
                    continue;
                }
                for (String relativeWord : relativeWords) {
                    // 广度总是最先得到最短的路径，使用过得节点直接跳过即可
                    if (occupied.containsKey(relativeWord)) {
                        continue;
                    }
                    Situation fork = s.clone();
                    fork.endWord = relativeWord;
                    fork.length += 1;
                    occupied.put(relativeWord, true);
                    if (Objects.equals(fork.beginWord, beginWord) && Objects.equals(fork.endWord, endWord)) {
                        return fork.length;
                    }
                    deque.addLast(fork);
                }
            }
        }
        return 0;
    }
}