<?php
/**
* 接雨水
*/
class Solution {

    /**
     * @param Integer[] $height
     * @return Integer
     */
    function trap($height) {
        $sum = 0;
        $current = 0;
        $length = count($height);
        $stack = [];
        
        // 从零开始遍历数组
        while ($current < $length) {
            // 如果栈不为空，且当前值的高度大于栈顶元素的高度，则开始出栈，计算积水高度
            while (!empty($stack) && $height[$current] > $height[$this->peek($stack)]) {
                $last = array_pop($stack); //栈顶元素
                $h = $height[$last]; // 栈顶元素对应的高度

                if (empty($stack)) break; 

                $distance = $current - $this->peek($stack) - 1; // 左右墙间距离 @TODO
                $min = min($height[$this->peek($stack)], $height[$current]); // 左右墙相对较小的值 @TODO
                $sum = $sum + $distance * ($min - $h);  // 计算积水值
            }
            array_push($stack, $current);
            $current++;
        }
        return $sum;
    }
    
    /**
    * 获取栈顶元素值
    * @param Integer[] $stack
    * @return Integer
    */                           
    function peek($stack) {
        return $stack[count($stack) - 1];
    }
}
