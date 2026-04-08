class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String odd = this.expand(s, i, i);
            String even = this.expand(s, i, i + 1);

            String palindrome = odd.length() > even.length() ? odd : even;
            if (palindrome.length() > result.length()) {
                result = palindrome;
            }
        }
        return result;
    }

    public String expand(String s, int left, int right) {
        while (
            left >= 0 && 
            right < s.length() &&
            s.charAt(left) == s.charAt(right)
        ) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}