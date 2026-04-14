class Solution {
    public int divisorSubstrings(int num, int k) {
        String numString = String.valueOf(num);

        int count = 0;
        for (int i = 0; i <= numString.length() - k; i++) {
            int divsor = Integer.parseInt(numString.substring(i, i + k));

            if (divsor != 0 && num % divsor == 0) {
                count++;
            }
        }
        return count;
    }
}