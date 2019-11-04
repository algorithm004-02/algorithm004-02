class Solution {
    private int robotX;
    private int robotY;
    private void forward(int angle, int steps, int[][] obstacles) {
        if (steps == 0) {
            return;
        }
        int ty, tx;
        switch (angle) {
            case 0:
                tx = robotX;
                ty = robotY + 1;
                break;
            case 90:
                tx = robotX + 1;
                ty = robotY;
                break;
            case 180:
                tx = robotX;
                ty = robotY - 1;
                break;
            default:
                tx = robotX - 1;
                ty = robotY;
                break;
        }
        for (int i = 0; i < obstacles.length; i++) {
            if (obstacles[i][0] == tx && obstacles[i][1] == ty) {
                tx = robotX;
                ty = robotY;
                return;
            }
        }
        robotX = tx;
        robotY = ty;
        forward(angle, steps - 1, obstacles);
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        int angle = 0;
        int result = 0;
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case -1:
                    angle += 90;
                    break;
                case -2:
                    angle -= 90;
                    break;
                default:
                    angle %= 360;
                    angle = angle < 0 ? angle + 360 : angle;
                    forward(angle, commands[i], obstacles);
                    break;
            }
            result = Math.max(robotX * robotX + robotY * robotY, result);
        }
        return result;
    }
}