class LeetCode_169_487{
    /***
     *
     * 169求众数
     *
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *
     * 思路:
     *      1：直接快排，取n/2下标的位置，
     *      2：用map记录出现的次数
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        //思路1
        Arrays.sort(nums);
        return nums[(nums.length / 2)];


//        //思路2:
//        Map<Integer, Integer> map = new HashMap<>();
//        int maxCountNumber = nums[0];  //出现次数最多的数字
//        for (int i = 0; i < nums.length; i++) {
//            int num = nums[i];
//            if (map.containsKey(num)) {
//                Integer count = map.get(num);
//                map.put(num, count + 1);
//                //如果加入的数和当前记录的最大出现次数的数不一样，就比较当前出现的次数是否大于最大出现次数的数，如果大就替换
//                if (num != maxCountNumber) {
//                    maxCountNumber = count + 1 > map.get(maxCountNumber) ? num : maxCountNumber;
//                }
//            } else {
//                map.put(num, 1);
//            }
//        }
//        return maxCountNumber;
    }

}