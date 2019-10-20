<?php
/**
 * 旋转数组
 */
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $k
     * @return NULL
     */
    function rotate(&$nums, $k) {
        $length = count($nums);
        $k = $k % $length;
        $count = 0;

        for ($start = 0; $count < $length; $start++) {
            $current = $start;
            $prev = $nums[$current];

            do {
                $next = ($current + $k) % $length;
                $temp = $nums[$next];
                $nums[$next] = $prev;
                $prev = $temp;
                $current = $next;
                $count++;
            } while ($current !== $start);
        }
    }
}
