class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        for (int i = 2; i < s.length(); i++) {
            Character c1 = s.charAt(i - 2);
            Character c2 = s.charAt(i - 1);
            Character c3 = s.charAt(i);
            if (
                c1 != c2 && c2 != c3 && c3 != c1
            ) {
                count++;
            }
        }        
        return count;
    }
}