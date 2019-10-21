<?php
/**
 * 删除排序数组中的重复项
 */
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function removeDuplicates(&$nums) {
        $i = 0;

        for ($j = 1; $j < count($nums); $j++) {
            if ($nums[$j] !== $nums[$i]) {
                $i++;
                $nums[$i] = $nums[$j];
            }
        }

        return $i+1;

    }
}
