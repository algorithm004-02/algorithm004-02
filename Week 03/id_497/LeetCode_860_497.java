class Solution {
    int[] counts = new int[3];
    public boolean lemonadeChange(int[] bills) {

        for (int i = 0; i <bills.length ; i++) {
            if(bills[i]==5){
                counts[0]++;
            }else if(bills[i]==10){
                if(counts[0]<1){
                    return false;
                }
                counts[1]++;
                counts[0]--;
            }else {
                if(!solve20()){
                    return false;
                }
            }

        }
        return true;
    }

    public boolean solve20(){
        if(counts[1]>0&&counts[0]>0){
            counts[1]--;
            counts[0]--;
        }else if(counts[1]==0&&counts[0]>2){
            counts[0] =counts[0]-3;
        }else {
            return false;
        }
        return true;
    }
}