import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList();
        Map<Character, String> map = new HashMap();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        if (digits.length() == 0){
            return list;
        }
        combine("",0, digits, list, map);
        return list;
    }

    public void combine(String s,int level, String digits, List<String> list, Map<Character, String> map) {
        if(level >= digits.length()){
            list.add(s);
            return;
        }

        String letters = map.get(digits.charAt(level));
        for(int i = 0; i < letters.length(); i++){
            combine(s + letters.charAt(i),level + 1,digits,list,map);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List list = solution.letterCombinations("");
        System.out.println(list);
    }
}