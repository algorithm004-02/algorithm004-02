package com.algorithm.qinchao.homework.week06;

import java.util.*;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/21 17:05
 * @description
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 * 注意:
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 * 示例 1:
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * 返回值: 1
 * 示例 2:
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * 返回值: 2
 * 示例 3:
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * 返回值: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-genetic-mutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_433_202 {
    public int minMutationByBFS(String start, String end, String[] bank) {
        if (bank.length == 0) {
            return -1;
        }
        List<String> bankList = Arrays.asList(bank);
        if (!bankList.contains(end)) {
            return -1;
        }
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        char[] genes = {'A', 'C', 'G', 'T'};
        int count = 0;
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                String current = queue.poll();
                if (end.equals(current)) {
                    return count;
                }
                getNext(visited, queue, current, bankList, genes);
            }
            count++;
        }
        return -1;
    }

    private void getNext(Set<String> visited, LinkedList<String> queue, String current, List<String> bankList, char[] genes) {
        char[] chars = current.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char oldCurr = chars[i];
            for (char gene : genes) {
                if (chars[i] != gene) {
                    chars[i] = gene;
                    String strCurr = String.valueOf(chars);
                    // 存在则为符合要求(每一次基因变化的结果都需要是一个合法的基因串)
                    if (!visited.contains(strCurr) && bankList.contains(strCurr)) {
                        visited.add(strCurr);
                        // 入队
                        queue.add(strCurr);
                    }
                }
            }
            chars[i] = oldCurr;
        }
    }
    public int minMutationByDoubleBFS(String start, String end, String[] bank) {
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        startSet.add(start);
        endSet.add(end);
        visited.add(start);
        visited.add(end);
        char[] genes = {'A', 'C', 'G', 'T'};
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) {
            return -1;
        }
        int result = 0;
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            if (startSet.size() > endSet.size()) {
                Set<String> change = startSet;
                startSet = endSet;
                endSet = change;
            }
            for (String word : startSet) {
                Set<String> temp = new HashSet<>();
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char oldCurr = chars[i];
                    for (char gene : genes) {
                        if (chars[i] != gene) {
                            chars[i] = gene;
                            String strCurr = String.valueOf(chars);
                            if (endSet.contains(strCurr)) {
                                return result + 1;
                            }
                            // 存在则为符合要求(每一次基因变化的结果都需要是一个合法的基因串)
                            if (!visited.contains(strCurr) && bankSet.contains(strCurr)) {
                                visited.add(strCurr);
                                temp.add(strCurr);
                            }
                        }
                    }
                    chars[i] = oldCurr;
                }
                result++;
                startSet = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_433_202().minMutationByBFS("AAAAACCC","AACCCCCC",new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
        System.out.println(new LeetCode_433_202().minMutationByDoubleBFS("AAAAACCC","AACCCCCC",new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));

        //"AAAAAAAA"
        //"CCCCCCCC"
        //["AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA","CCCCCCCC"]
        System.out.println(new LeetCode_433_202().minMutationByDoubleBFS("AAAAAAAA","CCCCCCCC",new String[]{"AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA","CCCCCCCC"}));
    }
}
