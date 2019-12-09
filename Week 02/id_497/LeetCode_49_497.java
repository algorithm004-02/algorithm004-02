class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> group = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String ss = Arrays.toString(chars);
            if (map.get(ss) != null) {
                map.get(ss).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(ss, list);
            }
        }
        Iterator<String> its = map.keySet().iterator();
        while (its.hasNext()) {
            String key = its.next();
            group.add(map.get(key));
        }

        return group;

    }
}