public List<List<String>> groupAnagrams(String[] strs) {
    if (strs.length == 0) {
        return new ArrayList();
    }
    Map<String, List> ans = new HashMap<String, List>();

    for (String i : strs) {
        char[] tmp = i.toCharArray();
        Arrays.sort(tmp);
        String key = String.valueOf(tmp);

        if (!ans.containsKey(key)) {
            ans.put(key, new ArrayList());
        }
        ans.get(key).add(i);
    }
    return new ArrayList(ans.values());
}
