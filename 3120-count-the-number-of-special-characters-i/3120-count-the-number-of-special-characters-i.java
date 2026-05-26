class Solution {
    public int numberOfSpecialChars(String word) {
        int lower_case = 0;
        int upper_case = 0;

        for (char ch : word.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                lower_case |= (1 << (ch - 'a'));
            } else {
                upper_case |= (1 << (ch - 'A'));
            }
        }

        int res = 0;

        for (int i = 0; i < 26; i++) {
            if ((lower_case & (1 << i)) != 0 &&
                (upper_case & (1 << i)) != 0) {
                res++;
            }
        }

        return res;
    }
}