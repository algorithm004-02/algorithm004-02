package datastruct.dfsAndbfs;

import javax.management.QueryEval;
import java.util.*;

/**
 * 433. 最小基因变化
 *
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。

 注意:
 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 所有的目标基因序列必须是合法的。
 假定起始基因序列与目标基因序列是不一样的。

 示例 1:
 start: "AACCGGTT"
 end:   "AACCGGTA"
 bank: ["AACCGGTA"]
 返回值: 1

 示例 2:
 start: "AACCGGTT"
 end:   "AAACGGTA"
 bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 返回值: 2

 示例 3:
 start: "AAAAACCC"
 end:   "AACCCCCC"
 bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 返回值: 3

 *
 */
public class MinimumGeneticMutation {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        //System.out.println(queue.poll());

        // start: "AACCGGTT"
//        end:   "AAACGGTA"
//        bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

//        "AACCGGTT"
//        "AACCGCTA"
//                ["AACCGGTA","AACCGCTA","AAACGGTA"]

//        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
//        MinimumGeneticMutation mutation = new MinimumGeneticMutation();
//        System.out.println(mutation.minMutation2("AACCGGTT", "AAACGGTA", bank));

//        String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
//        MinimumGeneticMutation mutation = new MinimumGeneticMutation();
//        System.out.println(mutation.minMutation2("AAAAACCC", "AACCCCCC", bank));

//        "AACCGGTT"
//        "AAACGGTA"
//                ["AACCGATT","AACCGATA","AAACGATA","AAACGGTA"]


//
//        String[] bank = {"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"};
//        MinimumGeneticMutation mutation = new MinimumGeneticMutation();
//        System.out.println(mutation.minMutation2("AACCGGTT", "AAACGGTA", bank));

//        "AACCGGTT"
//        "AACCGGTA"
//                ["AACCGGTA"]

//        String[] bank = {"AACCGGTA"};
//        MinimumGeneticMutation mutation = new MinimumGeneticMutation();
//        System.out.println(mutation.minMutation2("AACCGGTT", "AACCGGTA", bank));

//        "AACCTTGG"
//        "AATTCCGG"
//                ["AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"]
        String[] bank = {"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"};
        MinimumGeneticMutation mutation = new MinimumGeneticMutation();
        System.out.println(mutation.minMutation2("AACCTTGG", "AATTCCGG", bank));
    }


    public int minMutation(String start, String end, String[] bank) {
        // 当前开始序列与目标序列一致时候，无法进行变化，返回0
        if (start.equals(end)) return 0;

        // 创建一个基因库集合，把基因库重复的序列去掉，并存储起来
        Set<String> bankSet = new HashSet<>();
        for (String b : bank) bankSet.add(b);

        // 存入单个基因到数组中
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};

        // 开始次数设为0
        int level = 0;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        // 把起始序列存放到队列和visited中，后续做判断
        queue.offer(start);
        visited.add(start);

        // 遍历非空队列
        while (!queue.isEmpty() && queue.size() > 0) {
            //while (size-- > 0) { // 比较队列长度大于0时候遍历
            String curr = queue.poll(); // 移除并返问队列头部的元素，如果队列为空，则返回null
            int size = queue.size();

            if (curr.equals(end)) return level; // 当前序列跟目标序列一致时候返回变化次数

            char[] currArray = curr.toCharArray(); // 当前序列转为char数组
            for (int i = 0; i < currArray.length; i++) { // 遍历当前序列数组
                char old = currArray[i]; // 存储当前序列数组下标为i的值到变量old中

                // 遍历默认基因元素
                for (char c : charSet) {
                    currArray[i] = c; // 改变当前下标为i的序列数组的值
                    String next = new String(currArray);
                    // 判断visited中不存在改变后的序列并且基因库中存在改变后序列
                    if (!visited.contains(next) && bankSet.contains(next)) {
                        // 存放改变后序列到队列和visited中
                        visited.add(next);
                        queue.offer(next);
                        System.out.println(next);
                    }
                }
                currArray[i] = old; // 复原序列
            }
            if (size != queue.size())
                level++;
        }
        //}

        return -1;
    }

    public int minMutation2(String start, String end, String[] bank) {
        // 当前开始序列与目标序列一致时候，无法进行变化，返回0
        if (start.equals(end)) return 0;
        if (bank==null||bank.length == 0) return -1;

        // start序列转为char数组
        char[] startArray = start.toCharArray(); // 当前序列转为char数组

        // end序列转为char数组
        char[] endArray = end.toCharArray();


        Map<String,Integer> dfMap = new TreeMap<>();
        Map<String,Integer> startMap = new TreeMap<>();
        int endCount = 0;
        for (int i = 0;i < endArray.length; i++) {
            for (String subbank:bank) {
                if (!subbank.equals(end)) {
                    char bankChar =subbank.charAt(i);
                    if (bankChar != endArray[i]) {
                        int count = dfMap.get(subbank) == null ? 0:dfMap.get(subbank);
                        dfMap.put(subbank,++count);
                        System.out.println(subbank);
                    }
                    if (bankChar != startArray[i]) {
                        int count = startMap.get(subbank) == null ? 0:startMap.get(subbank);
                        startMap.put(subbank,++count);
                    }
                }
                else
                {
                    if(endArray[i] != startArray[i]) {
                        endCount ++;
                    }
                }
            }

        }

        String key = "";

        for (Map.Entry<String,Integer> entry : startMap.entrySet()) {
            if (entry.getValue() == 1)
                key = entry.getKey();
        }

        return dfMap.get(key)!=null?dfMap.get(key)+1:endCount!=1?-1:endCount;
    }

    public int minMutation1(String start, String end, String[] bank) {
        // 当前开始序列与目标序列一致时候，无法进行变化，返回0
        if (start.equals(end)) return 0;
        if (bank==null||bank.length == 0) return -1;

        // 创建一个基因库集合，把基因库重复的序列去掉，并存储起来
        Set<String> bankSet = new HashSet<>();
        for (String b : bank) bankSet.add(b);


        // 存入单个基因到数组中
        // char[] charSet = new char[]{'A', 'C', 'G', 'T'};

        // start序列转为char数组
        char[] startArray = start.toCharArray(); // 当前序列转为char数组

        // end序列转为char数组
        char[] endArray = end.toCharArray();

        // 初始化不同map
        Map<Integer,Character> dfMap = new TreeMap<>();


        // List<Character> dfList = new ArrayList<>();
        for (int i = 0;i < startArray.length; i++) {
            if (startArray[i]!=endArray[i]) {
                dfMap.put(i,endArray[i]);
                //dfList.add(endArray[i]);
            }
        }

        for (String subBank:bankSet) {
            for (Map.Entry<Integer,Character> entry : dfMap.entrySet()) {
                if (subBank.charAt(entry.getKey()) != entry.getValue()&&subBank.charAt(entry.getKey())!=startArray[entry.getKey()]) {
                    return -1;
                }
            }
        }

        //int count = 0;
//        for (Map.Entry<Integer,Character> entry : dfMap.entrySet()) {
//            //char old = startArray[entry.getKey()];
//            startArray[entry.getKey()] = entry.getValue();
//            String next = new String(startArray);
//            if (!bankSet.contains(next)) {
//                // 存放改变后序列到队列和visited中
//                 return -1;
//            }
//            //startArray[entry.getKey()] = old;
//        }
        return dfMap.size();
    }
}
