class Solution {
    /**
        排序数组分类
        时间复杂度：O(NKlogK)，
                其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。
                当我们遍历每个字符串时，外部循环具有的复杂度为 O(N)。
                然后，我们在O(KlogK) 的时间内对每个字符串排序。

        空间复杂度：O(NK)，排序存储在 ans 中的全部信息内容。
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        
        Map<String, List> ans = new HashMap<String, List>();
        for (String str : strs) {
            char[] cas = str.toCharArray();
            Arrays.sort(cas);
            String key = String.valueOf(cas);
            if (!(ans.containsKey(key))) {  //若不存在，则新加入一个key/value
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(str);
        }
        return new ArrayList(ans.values());
    }
}