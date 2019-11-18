package Week02;


import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Solution49 {

    /**
     * 自己鼓捣出来的方法
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {

        int n = strs.length;

        if (n == 0) {
            return null;
        }

        List<List<String>> l = new ArrayList<>();
        boolean[] flag = new boolean[n];
        String[] s = new String[n];
        boolean equal = false;

        for (int i = 0; i < n; i++) {
            //String str = strs[i];
            flag[i] = false;
            s[i] = strs[i];
        }

        for (int i = 0; i < n; i++) {

            if (flag[i]) continue;

            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);

            List<String> list = new ArrayList<>();
            list.add(s[i]);
            for (int j = i + 1; j < n; j++) {

                if(flag[j]) continue;

                char[] arr = strs[j].toCharArray();
                Arrays.sort(arr);
                //比较
                equal = Arrays.equals(charArr, arr);
                if (equal) {
                    flag[j] = true;
                    list.add(s[j]);
                }
            }
            l.add(list);
        }
        return l;
    }


    /** 官方答案 */
    public List<List<String>> groupAnagrams1(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){

            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if(!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
