<?php
/**
 * 两数求和问题
 */
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        $res = $hashMap = [];

        forEach ($nums as $k => $v) {
            if (isset($hashMap[$v]) && $hashMap[$v] !== $k) {
                $res = [$hashMap[$v], $k];
                break;
            }
            $hashMap[$target - $v] = $k;
        }

        return $res;
    }
}
