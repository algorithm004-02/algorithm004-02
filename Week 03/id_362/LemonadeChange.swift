class Solution {
    func lemonadeChange(_ bills: [Int]) -> Int {
        var five = 0
        var ten = 0
        for bill in bills {
            if bill == 5 {
               five += 1 
            } else if bill == 10 {
                if five == 0 { return false }
                five -= 1
                ten += 1
            } else {
                if five > 0 && ten > 0 {
                    five -= 1
                    ten -= 1
                } else if five >= 3 {
                    five -= 3
                } else {
                    return false
                }
            }
        }
        return true
    }
}
