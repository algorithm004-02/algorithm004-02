class Solution {
public List<String> letterCombinations(String digits) {//暴力循环
        if(digits == null || digits.trim().equals("")){
            return new ArrayList<>();
        }
        Map<String,String[]> map = new HashMap<>();
        map.put("2",new String[]{"a","b","c"});
        map.put("3",new String[]{"d","e","f"});
        map.put("4",new String[]{"g","h","i"});
        map.put("5",new String[]{"j","k","l"});
        map.put("6",new String[]{"m","n","o"});
        map.put("7",new String[]{"p","q","r","s"});
        map.put("8",new String[]{"t","u","v"});
        map.put("9",new String[]{"w","x","y","z"});
        char[] chars = digits.toCharArray();
        List<String> list = Arrays.asList(map.get(String.valueOf(chars[0])));
        for (int i = 1; i < chars.length; i++) {
            List<String> target = new ArrayList<>();
            for (String s : list) {
                for (String string : map.get(String.valueOf(chars[i]))) {
                    target.add(s+string);
                }
            }
            list = target;

        }
        return list;
    }
}

//-------------------------------老师方法改写

