import java.util.HashSet;
import java.util.Set;

public class LeetCode_874_047 {

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obst:
             obstacles) {
            obstacleSet.add(obst[0] + "_" + obst[1]);
        }
        int degree = 90;
        int x = 0;
        int y = 0;
        int result = 0;
        for (int acommand :
                commands) {
            if (acommand == -1) {
                degree = (degree + 360 - 90) % 360;
            } else if (acommand == -2) {
                degree = (degree + 360 + 90) % 360;
            } else {
                for (int k = 0; k < acommand; k ++) {
                    int nextX = x;
                    int nextY = y;
                    if (degree == 0) {
                        nextX ++;
                    } else if (degree == 90) {
                        nextY ++;
                    } else if (degree == 180) {
                        nextX --;
                    } else {
                        nextY --;
                    }
                    if (obstacleSet.contains(nextX + "_" + nextY)) {
                        break;
                    } else {
                        x = nextX;
                        y = nextY;
                    }
                }
                result = Math.max(result,x * x + y * y);
            }
        }
        return result;
    }
}
