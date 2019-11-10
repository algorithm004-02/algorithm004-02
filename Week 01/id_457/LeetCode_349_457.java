class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set hashSet = new HashSet();
        for (int i=0;i<nums1.length;i++) {
            hashSet.add(nums1[i]);
        }


        List<Integer> resNums = new ArrayList<Integer>();
        for (int i=0;i<nums2.length;i++) {
            if (hashSet.contains(nums2[i])) {
                resNums.add(nums2[i]);
                hashSet.remove(nums2[i]);
            }
        }

        int[] resArray  = new int[resNums.size()];
        for (int i=0;i<resNums.size();i++) {
            resArray[i] = resNums.get(i);
        }
        return resArray;
    }
}