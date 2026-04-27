class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int result = 0;
        boolean hasOdd = false;
        for (int count : map.values()) {
            result += (count / 2) * 2;

            if (count % 2 != 0) {
                hasOdd = true;
            }
        }

        return hasOdd ? result + 1 : result;
    }
}