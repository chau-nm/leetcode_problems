class Solution {
    public int minimumRecolors(String blocks, int k) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= blocks.length() - k; i++) {
            int count = 0;
            for (int j = i; j < i + k; j++) {
                if (blocks.charAt(j) == 'W') {
                    count++;
                }
            }
            min = Math.min(min, count);
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}