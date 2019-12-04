public boolean isAnagram(String s, String t) {
            char[] s_chars = s.toCharArray();
            char[] t_chars = t.toCharArray();
            Arrays.sort(s_chars);
            Arrays.sort(t_chars);
            s = String.valueOf(s_chars);
            t = String.valueOf(t_chars);
            return s.equals(t) ? true : false;
        }