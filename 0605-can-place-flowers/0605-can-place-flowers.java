class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            
            int left = i == 0 ? 0 : i - 1;
            int right = i == flowerbed.length - 1 ? flowerbed.length - 1 : i + 1;

            if (flowerbed[left] == 0 && flowerbed[right] == 0) {
                flowerbed[i] = 1;
                count++;

                if (count >= n) {
                    return true;
                }
            }
        }

        return count >= n;
    }
}