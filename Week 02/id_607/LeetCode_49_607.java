
//leetcode submit region end(Prohibit modification and deletion)
//1. hashMap, key = '排序后的str' ,value = ['',''];
//2. hashMap, key = '26个字母计数组成的string,比如2011...', value = ['','']
class Solution {
//    public List<List<String>> groupAnagrams(String[] strs) {
//        if (strs.length == 0) return new ArrayList<>();
//        Map<String, ArrayList> countMap = new HashMap<>();
//        for (String str : strs) {
//            char[] chaArr = str.toCharArray();
//            Arrays.sort(chaArr);
//            String key = String.valueOf(chaArr);
//            if (!countMap.containsKey(key)) countMap.put(key, new ArrayList());
//            countMap.get(key).add(str);
//        }
//        return new ArrayList(countMap.values());
//    }
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, ArrayList> countMap = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            Arrays.fill(count, 0);
            for (char cha : str.toCharArray()) {
                count[cha - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int num : count) {
                sb.append(num);
            }
            if (!countMap.containsKey(sb.toString())) countMap.put(sb.toString(), new ArrayList());
            countMap.get(sb.toString()).add(str);
        }
        return new ArrayList(countMap.values());
    }
}