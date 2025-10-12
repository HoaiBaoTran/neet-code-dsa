class Solution {
    public int maxArea(int[] heights) {
        int maxCapacity = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            int length = Math.min(heights[left], heights[right]);
            int capacity = length * (right - left);
            maxCapacity = Math.max(capacity, maxCapacity);

            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxCapacity;
    }

    // brute force
    /*
     * public int maxArea(int[] heights) {
     * int maxCapacity = 0;
     * for (int i = 0; i < heights.length - 1; i++) {
     * for (int j = i + 1; j < heights.length; j++) {
     * int length = Math.min(heights[i], heights[j]);
     * int capacity = length * (j - i);
     * if (capacity > maxCapacity) {
     * maxCapacity = capacity;
     * }
     * }
     * }
     * return maxCapacity;
     * }
     */
}