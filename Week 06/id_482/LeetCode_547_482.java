package com.study.week6.lesson13;

public class LeetCode_547_482 {

    /**
     * 使用深度优先搜索，类似岛屿个数的题目
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        //二维数组长度，即所有人的个数
        int length = M.length;
        //统计朋友圈个数
        int count = 0;
        //访问标志
        boolean[] flag = new boolean[length];
        //对于每个人
        for(int i = 0;i < length;i++){
            //如果未被访问
            if(flag[i] == false){
                DFS(i,M,flag);//深度优先搜索，访问
                count++;//朋友圈个数+1
            }
        }
        return count;
    }

    public void DFS(int i,int[][] M,boolean[] flag){
        flag[i] = true;

        for(int j = 0;j < M[i].length;j++){
            if(flag[j] == false && M[i][j] == 1){
                DFS(j,M,flag);
            }
        }
    }
}
