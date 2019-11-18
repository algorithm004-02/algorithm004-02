class Solution {
    public int trap(int[] height) {
        if (height.length == 0 || height.length == 1 || height.length == 2) {
            return 0;
        }
        int rain = 0;
        int maxIndex = findMaxIndex(height, 0, height.length);
        rain = getTotalLeftRain(maxIndex, height, rain);
        rain = getTotalRightRain(maxIndex, height, rain);
        return rain;
    }


    private int getTotalLeftRain(int maxIndex, int[] height, int rain) {
        if (maxIndex <= 1) return rain;
        int firstMaxLeft = maxIndex;
        int secondMaxLeft = findMaxIndex(height, 0, maxIndex);
        if (height[secondMaxLeft] < height[firstMaxLeft]) {
            for (int i = secondMaxLeft; i < firstMaxLeft; i++) {
                int con = height[secondMaxLeft] - height[i];
                rain += con < 0 ? 0 : con;
            }
        } else {
            for (int i = secondMaxLeft; i < firstMaxLeft; i++) {
                int con = height[firstMaxLeft] - height[i];
                rain += con < 0 ? 0 : con;
            }
        }
        return getTotalLeftRain(secondMaxLeft, height, rain);
    }

    private int getTotalRightRain(int maxIndex, int[] height, int rain) {
        if (maxIndex >= height.length - 2) return rain;
        int firstMaxRight = maxIndex;
        int secondMaxRight = findMaxRightIndex(height, maxIndex + 1, height.length);
        if (secondMaxRight > 0) {
            if (height[firstMaxRight] < height[secondMaxRight]) {
                for (int i = firstMaxRight; i < secondMaxRight; i++) {
                    int con = height[firstMaxRight] - height[i];
                    rain += con < 0 ? 0 : con;
                }
            } else {
                for (int i = firstMaxRight; i < secondMaxRight; i++) {
                    int con = height[secondMaxRight] - height[i];
                    rain += con < 0 ? 0 : con;
                }
            }
        }
        return getTotalRightRain(secondMaxRight, height, rain);
    }


    private int findMaxIndex(int[] height, int i, int i1) {
        int max = height[i];
        int index = i;
        for (int j = i + 1; j < i1; j++) {
            if (height[j] > max) {
                max = height[j];
                index = j;
            }
        }
        return index;
    }

    private int findMaxRightIndex(int[] height, int i, int i1) {
        if (i >= i1) return -1;
        int max = height[i];
        int index = i;
        for (int j = i + 1; j < i1; j++) {
            if (height[j] >= max) {
                max = height[j];
                index = j;
            }
        }
        return index;
    }
}