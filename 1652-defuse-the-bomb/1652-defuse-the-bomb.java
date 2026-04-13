class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        int previousSum = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;

            if (k > 0) {
                if (previousSum > 0) {
                    sum = previousSum - code[i] + code[(i + k) % n];
                } else {
                    for (int j = 1; j <= k; j++) {
                        sum += code[(i + j) % n];
                    }
                }
            }
            if (k < 0) {
                if (previousSum > 0) {
                    sum = previousSum - code[(i + k + n - 1) % n] + code[(i - 1 + n) % n];
                } else {
                    for (int j = 1; j <= -k; j++) {
                        sum += code[(i - j + n) % n];
                    }
                }
            }

            previousSum = sum;
            result[i] = sum;
        }

        return result;
    }
}