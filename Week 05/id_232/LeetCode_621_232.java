package src.main.java.com.fans.algorithm00402.week5.homework;

import java.sql.Connection;
import java.util.*;

/**
 * 任务调度器
 */
public class LeetCode_621_232 {

    /**
     * 排序
     */
//    public int leastInterval(char[] tasks, int n) {
//        int[] map = new int[26];
//        for (char ch : tasks)
//            map[ch - 'A'] ++;
//        Arrays.sort(map);
//        int times = 0;
//        while (map[25] > 0) {
//            int i = 0;
//            while (i <= n) {
//                if (map[25] == 0) break;
//                if (i < 26 && map[25 - i] > 0) map[25 - i] --;
//                i++;
//                times++;
//            }
//            Arrays.sort(map);
//        }
//        return times;
//    }

    /**
     * 优先队列
     */
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char ch : tasks)
            map[ch - 'A'] ++;
        PriorityQueue<Integer> queue = new PriorityQueue(26, Collections.reverseOrder());
        for (int f : map)
            if (f > 0)
                queue.add(f);
        int times = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1)
                        temp.add(queue.peek() - 1);
                    queue.poll();
                }
                times++;

                if (queue.isEmpty() && temp.size() == 0)
                    break;
                i ++;
            }
            for (int l : temp)
                queue.add(l);
        }
        return times;
    }

}
