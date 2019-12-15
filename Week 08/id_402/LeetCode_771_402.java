class Solution_771 {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (char gem : J.toCharArray()) {
            set.add(gem);
        }
        for (char stone : S.toCharArray()) {
            if (set.contains(stone)) {
                count ++;
            }
        }
        return count;
    }
}