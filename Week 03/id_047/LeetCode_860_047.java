public class LeetCode_860_047 {

    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return true;
        }
        int[] pocket = new int[3];
        for (int abill :
                bills) {
            if (abill == 5) {
                pocket[0]++;
            } else if (abill == 10) {
                if (pocket[0] == 0) {
                    return false;
                }
                pocket[0]--;
                pocket[1]++;
            } else if (abill == 20) {
                if (pocket[1] > 0 && pocket[0] > 0) {
                    pocket[0]--;
                    pocket[1]--;
                    pocket[2]++;
                } else if (pocket[0] > 2) {
                    pocket[0] = pocket[0] - 3;
                    pocket[2]++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
