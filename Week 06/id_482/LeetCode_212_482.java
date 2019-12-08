package com.study.week6.lesson13;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LeetCode_212_482 {
    public List<String> findWords(char[][] board, String[] words) {
        // 把 words 放入字典树
        Trie trie = new Trie();
        for (String word : words)
            trie.insert(word);

        int row=board.length;
        int col=board[0].length;
        boolean [][] visited=new boolean [row][col];
        Set<String> results=new HashSet<String>();
        // 遍历 board
        for (int i=0;i<row;i++)
            for (int j=0;j<col;j++)
                find(board,visited,i,j,row,col,results,trie.root);

        return new LinkedList<String>(results);
    }

    public void find(char [][] board,boolean [][]  visited,int i,int j,int row,int col,Set<String> res,TrieNode node) {
        //先判断边界
        if (i<0 || i>=row || j <0 || j>=col || visited[i][j])
            return;

        node=node.children[board[i][j] - 'a'];

        if (null == node)
            return;

        if (node.val != null)
            res.add(node.val);

        visited[i][j] =true;
        // dfs
        find(board,visited,i-1,j,row,col,res,node);
        find(board,visited,i+1,j,row,col,res,node);
        find(board,visited,i,j-1,row,col,res,node);
        find(board,visited,i,j+1,row,col,res,node);
        visited[i][j] =false;
    }

    private class TrieNode {
        TrieNode [] children = new TrieNode [26];
        String val;
    }

    /**
     定义字典树
     */
    class Trie {

        public TrieNode root =new TrieNode();

        public void insert (String word) {
            TrieNode curr=root;
            int charNo=0;
            for (int i=0;i<word.length();i++) {
                charNo=word.charAt(i) - 'a';
                if (curr.children[charNo] == null )
                    curr.children[charNo]=new TrieNode();

                curr=curr.children[charNo];
            }
            //注意是把整个 word插入最后一个位置
            curr.val=word;
        }

    }

}

