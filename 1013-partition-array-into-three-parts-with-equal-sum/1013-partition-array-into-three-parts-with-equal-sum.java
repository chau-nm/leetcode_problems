class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+= arr[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        sum /= 3;

        int currentSum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum == sum) {
                currentSum = 0;
                count++;
            }
        }

        return count >= 3;
    }
}