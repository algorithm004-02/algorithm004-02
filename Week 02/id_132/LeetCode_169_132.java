package binarytree;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MajorityElement {
    public static void main(String[] args) {

        int[] intArr = new int[] {3,2,3};
        MajorityElement majorityElement = new MajorityElement();
        int a = majorityElement.getMajorityElement(intArr);
        System.out.println(a);
    }

    // 使用HashMap存储对应的元素及次数，找出次数大于二分之一数组长度的元素
    private int getMajorityElement(int[] intArr) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < intArr.length; i++) {
            int count = 0;
            if (map.containsKey(intArr[i])) {
                count = map.get(intArr[i]);
            }
            map.put(intArr[i], ++count);
        }
        AtomicInteger value = new AtomicInteger();
        map.keySet().forEach(ele -> {
            if (map.get(ele) > intArr.length / 2) {
                value.set(ele);
            }
        });
        return value.get();
    }


}
