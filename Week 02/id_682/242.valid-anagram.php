class Solution {

    /**
     * @param String $s
     * @param String $t
     * @return Boolean
     */
    function isAnagram($s, $t) {
        if (strlen($s) != strlen($t)) {
            return false;
        }
        
        $res = [];
        for ($i = 0; $i < strlen($s); $i++) {
            if (isset($res[$s[$i]])) {
                $res[$s[$i]]++;
            } else {
                $res[$s[$i]] = 1;
            }
            
            if (isset($res[$t[$i]])) {
                $res[$t[$i]]--;
            } else {
                $res[$t[$i]] = -1;
            }
        }
        
        foreach ($res as $val) {
            if ($val != 0) {
                return false;
            }
        }
        
        return true;
    }
}