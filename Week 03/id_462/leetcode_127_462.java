/**
 *  单词接龙
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) {
            return 0;
        }
        Map<String,ArrayList<String>> wordMappings = new HashMap<String,ArrayList<String>>();

        for(String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String key = word.substring(0,i) + "*" + word.substring(i + 1,word.length());
                ArrayList<String> wordLists = wordMappings.getOrDefault(key,new ArrayList<>());
                wordLists.add(word);
                wordMappings.put(key,wordLists);
            }
        }
        Queue<Map<String,Integer>> queue = new ArrayDeque<Map<String,Integer>>();
        HashMap<String,Integer> maps = new HashMap<>();
        maps.put(beginWord,1);
        queue.add(maps);
        Map<String,Boolean> visited = new HashMap<String,Boolean>(16);
        visited.put(beginWord,true);
        while (!queue.isEmpty()) {
            Map<String,Integer> mapsi = queue.poll();
            String word  = mapsi.keySet().iterator().next();
            Integer count = mapsi.values().iterator().next();
            for (int i = 0; i < word.length(); i++) {
                String key = word.substring(0,i) + "*" + word.substring(i + 1,word.length());
                ArrayList<String> wordLists = wordMappings.getOrDefault(key,new ArrayList<>());
                for (String wordi : wordLists) {
                    if (endWord.equals(wordi)) {
                        return count + 1;
                    }
                    if (!visited.containsKey(wordi)) {
                        visited.put(wordi,true);

                        HashMap<String,Integer> maps2 = new HashMap<>();
                        maps2.put(wordi,count + 1);
                        queue.add(maps2);
                    }
                }
            }
        }
        return 0;
    }
}