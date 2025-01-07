class Solution {
    public String reversePrefix(String word, char ch) {
        int chIndex = word.indexOf(ch);
        char[] chars = word.toCharArray();
        for (int i = 0; i < (chIndex + 1) / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chIndex - i];
            chars[chIndex - i] = temp;
        }
        return String.valueOf(chars);
    }
}