import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] student, int[] gift) {

        if (student == null || student.length == 0 || gift == null || gift.length == 0) {
            return 0;
        }

        //对胃口和饼干 排下序
        Arrays.sort(student);
        Arrays.sort(gift);

        //因为si从0开始，则si表示当前需要满足小孩子的index，也恰好等于已经满足小孩子的数量，即返回值
        int si = 0;
        int gi = 0;

        while (si < student.length && gi < gift.length) {
            if (student[si] <= gift[gi]) {
                si++;
                gi++;
            } else {
                gi++;
            }
        }

        return si;
    }
}