class Solution {
    public int maxDistance(int[] colors) {
        int max = 0;
        for (int i = 0; i < colors.length - 1; i++) {
            for (int j = i; j < colors.length; j++) {
                if (colors[i] != colors[j]) {
                    max = Math.max(max, Math.abs(j - i));
                }
            }
        }
        return max;
    }
}