class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 2, 4, 8 }, { 10, 11, 12, 13 }, { 14, 20, 30, 40 } };
        int[][] testMatrix = new int[][] { { 1, 1 } };
        int[][] testMatrix2 = new int[][] { { 1 }, { 3 } };
        int target = 2;
        System.out.println(searchMatrix(testMatrix2, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bot = matrix.length - 1;

        while (top <= bot) {
            int mid = (top + bot) / 2;
            if (target > matrix[mid][matrix[0].length - 1]) {
                top = mid + 1;
            } else if (target < matrix[mid][0]) {
                bot = mid - 1;
            } else {
                break;
            }
        }

        if (top > bot)
            return false;

        int l = 0;
        int r = matrix[0].length - 1;
        int midRow = (top + bot) / 2;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target < matrix[midRow][mid]) {
                r = mid - 1;
            } else if (target > matrix[midRow][mid]) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean searchMatrixOnePass(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int l = 0;
        int r = ROWS * COLS - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int row = m / COLS;
            int col = m % COLS;

            if (target > matrix[row][col]) {
                l = m + 1;
            } else if (target < matrix[row][col]) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}