package com.kaiyun.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algorithms
 * @description:
 * @author: Kaiyun
 * @create: 2019-11-24 22:38
 **/
public class LeetCode_547_157 {
    public int findCircleNum(int[][] M) {

        int[] visited = new int[M.length];
        int count = 0;
        Queue < Integer > queue = new LinkedList < > ();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0)
                            queue.add(j);
                    }
                }
                count++;
            }
        }
        return count;
    }

}
