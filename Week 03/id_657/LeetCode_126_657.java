package com.arithmetic.arithmetic.week03;

import java.util.*;

public class LeetCode_126_657 {
    // speed up
    Map<String, List<String>> neighborCache = new HashMap<>();
    Set<String> allwords = new HashSet<>();
    Set<String> visited = new HashSet<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<List<String>> paths = new LinkedList<>();
        allwords.addAll(wordList);
        List<String> initial = new ArrayList();

        initial.add(beginWord);
        visited.add(beginWord);
        int min = Integer.MAX_VALUE; // minimal answer
        int level = 1; // bfs, so which level are we in?
        ArrayList levelVisited = new ArrayList();
        paths.add(initial);

        List<List<String>> answers  = new ArrayList();
        if(!allwords.contains(endWord)){
            return new ArrayList<>();
        }

        while(!paths.isEmpty()){
            List<String> singlePath = paths.poll();
            // no need to proceed
            if(singlePath.size() >= min){
                continue;
            }

            if(singlePath.size() == level + 1){
                level++;
                visited.addAll(levelVisited);
                levelVisited.clear();
            }

            String tail = singlePath.get(singlePath.size() - 1 );
            List<String> neighbors = findNeighbors(tail);
            for(String s : neighbors){
                // not going back
                if(visited.contains(s)){
                    continue;
                }

                // found one, bfs gurrantees that this is the smallest once we found one
                if(s.equals(endWord)){
                    ArrayList answer = new ArrayList(singlePath);
                    answer.add(s);
                    min = answer.size();
                    answers.add(answer);
                    break;
                };

                ArrayList newPath = new ArrayList(singlePath);
                newPath.add(s);
                levelVisited.add(s);
                //bfs
                paths.add(newPath);
            };
        };
        return answers;
    }

    List<String> findNeighbors(String node){
        if(neighborCache.get(node) != null){
            return neighborCache.get(node);
        }
        List<String> neighbors = new ArrayList();
        char[] chars = node.toCharArray();
        for(int i = 0; i < chars.length; i++){
            for(char c = 'a'; c <= 'z'; c++){
                StringBuilder sb = new StringBuilder(node);
                sb.setCharAt(i,c);
                String potential = sb.toString();
                if(allwords.contains(potential)){
                    neighbors.add(potential);
                }
            }
        };
        neighborCache.put(node, neighbors);
        return neighbors;
    };



}
