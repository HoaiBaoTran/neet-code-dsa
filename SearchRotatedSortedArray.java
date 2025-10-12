class Solution {
    public static void main(String[] args){
        
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int res = -1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (target == nums[m]) {
                return m;
            }

            // left part
            if (nums[l] <= nums[m]) {
                if (target > nums[m] || target < nums[l]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            // right part
            else {
                if (target > nums[r] || target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

        }

        return res;
    }
}