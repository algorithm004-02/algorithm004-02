class Solution {
    private Map<Character,Character> mapping;
    public Solution() {
        this.mapping = new HashMap<Character,Character>();
        this.mapping.put(')', '(');
        this.mapping.put(']', '[');
        this.mapping.put('}', '{');
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i<s.length(); i++) {
            char sChar = s.charAt(i);
            if (this.mapping.containsKey(sChar)) {
                char topChar = stack.empty() ? '#' : stack.pop();
                if (topChar != this.mapping.get(sChar)) {
                    return false;
                }
            } else {
                stack.push(sChar);
            }
        }
        return stack.isEmpty();
    }
}