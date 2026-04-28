class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count == 0) {
                result++;                
            }
            if (s.charAt(i) == 'R') {
                count++;
            } else {
                count--;
            }
        }

        return result;
    }
}