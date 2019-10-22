
//创建键值对，进行匹配判断。
public static boolean isValid(String s) {
    Stack<Character> pool = new Stack<>();
    Map<Character,Character> judgeMap = new HashMap<>();
    char[] poolArr = s.toCharArray();
    judgeMap.put(')','(');
    judgeMap.put('}','{');
    judgeMap.put(']','[');
    for (char c : poolArr) {
        if(judgeMap.containsValue(c)){
            pool.push(c);
        }else if(judgeMap.containsKey(c)){
            if(pool.isEmpty() || pool.pop() != judgeMap.get(c)){
                return false;
            }
        }
    }
    return pool.isEmpty();
}