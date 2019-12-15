class LeetCode_387_487 {


    /**
     * 387. 字符串中的第一个唯一字符
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < length; i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}