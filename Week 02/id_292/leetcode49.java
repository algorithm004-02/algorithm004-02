/**
     * 判断两个字符串是否为异位词
     *
     * @param words1
     * @param words2
     * @return
     */
    public static boolean isEctopicWords(String words1, String words2) {
        if (words1 == null || words2 == null || words1.length() != words2.length()) {
            return false;
        }
        char[] array1 = words1.toCharArray();
        char[] array2 = words2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }