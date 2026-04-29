class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> (b[1] - a[1]));
        int count = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (truckSize <= 0) {
                return count;
            }
            count += boxTypes[i][0] <= truckSize ? boxTypes[i][0] * boxTypes[i][1] : truckSize * boxTypes[i][1];
            truckSize -= boxTypes[i][0];
        }
        return count;
    }
}