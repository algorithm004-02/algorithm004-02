public class Solution {
	public boolean lemonadeChange(int[] bills) {
		if(bills == null || bills.length == 0) {
			return false;
		}
		if(bills[0] != 5) {
			return false;
		}
		int fiveNums = 0;
		int tenNums = 0;
		for(int i = 0; i < bills.length; i++) {
			if(bills[i] == 5) {
				fiveNums++;
			} else if(bills[i] == 10 && fiveNums > 0) {
				tenNums++;
				fiveNums--;
			} else{
				if((tenNums > 0 && fiveNums > 0) ) {
					tenNums--;
					fiveNums--;
				} else if(fiveNums >= 3) {
					fiveNums -= 3;
				} else {
					return false;
				}
			}
		}	
		return true;
        
    }
}
