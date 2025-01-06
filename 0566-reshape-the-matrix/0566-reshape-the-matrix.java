class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) {
            return mat;
        }
        int[][] result = new int[r][c];
        int rIndex = 0;
        int cIndex = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (cIndex >= c) {
                    cIndex = 0;
                    rIndex++;
                }
                result[rIndex][cIndex++] = mat[i][j];
            }
        }
        return result;
    }
}