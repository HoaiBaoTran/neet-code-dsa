class BinarySearch {


    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,2,4,6,8}; 
        int target = 4;
        System.out.println(search(nums, target));

    }

    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int binarySearch(int[]nums, int start, int end, int target) {
        if (start == end)
            return -1;

        int midIndex = (end+start)/2;
        int mid = nums[midIndex];
        if (target < mid) {
            return binarySearch(nums, start, midIndex - 1, target);
        } else if (target > mid) {
            return binarySearch(nums, midIndex + 1, end, target);
        } else {
            return midIndex;
        }
    }
}
