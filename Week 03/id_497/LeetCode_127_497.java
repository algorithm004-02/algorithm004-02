import javafx.util.Pair;

import java.util.*;
class Solution {
    int wordLength;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        this.wordLength = beginWord.length();
        Map<String,ArrayList<String>> dictMap= new HashMap<String,ArrayList<String>>();
        wordList.forEach(word->{
            for (int i = 0; i < this.wordLength ; i++) {
                String key = word.substring(0,i)+'*'+word.substring(i+1,wordLength);
                ArrayList<String> arrayList = dictMap.getOrDefault(key,new ArrayList<>());
                arrayList.add(word);
                dictMap.put(key,arrayList);
            }
        });
        Queue<Pair<String,Integer>> stringQueue = new LinkedList<>();
        stringQueue.add(new Pair<>(beginWord,1));
        Map<String,Boolean> visitMap = new HashMap<>();
        visitMap.put(beginWord,true);
        List<List<String>> lists = new ArrayList<>();
        List<String> matchList = new ArrayList<>();
        matchList.add(beginWord);
        while (!stringQueue.isEmpty()){
            Pair<String,Integer> checkPoint= stringQueue.remove();
            for (int i = 0; i < this.wordLength ; i++) {
                String key = checkPoint.getKey().substring(0,i)+'*'+checkPoint.getKey().substring(i+1,wordLength);
                for (String match : dictMap.getOrDefault(key,new ArrayList<>())) {
                    if(match.equals(endWord)){
                        matchList.add(endWord);
                        return checkPoint.getValue()+1;
                    }
                    if(!visitMap.containsKey(match)){
                        visitMap.put(match,true);
                        stringQueue.add(new Pair<>(match,checkPoint.getValue()+1));
                    }
                }
            }
        }
         return 0;
    }
}