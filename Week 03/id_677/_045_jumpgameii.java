public class _045_jumpgameii {
    public static void main(String[] args) {
        int[] a = new int[] {2,3,1,1,4};
        ISolution s1 = new Solution1();
        int steps = s1.jump(a);
        System.out.println(steps);

    }
}

interface ISolution {
    int jump(int[] nums);
}

class Solution1 implements ISolution {
    @Override
    public int jump(int[] nums) {
        int steps = 0;
        int currentFarthest = 0;
        int nextFarthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            nextFarthest = Math.max(nextFarthest, nums[i] + i);
            if (i == currentFarthest) {
                steps++;
                currentFarthest = nextFarthest;
            }
        }

        return steps;
    }
}
