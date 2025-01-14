class Solution {
    public int countValidWords(String sentence) {
        String[] words = sentence.split(" ");
        int count = 0;
        for (String word : words) {
            if (isToken(word)) {
                count++;
            }
        }
        return count;
    }

    public boolean isToken(String word) {
        if (word.length() == 0) return false;
        int hyphenCount = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= '0' && ch <= '9') {
                return false;
            }
            if (ch == '-') {
                 if (i == 0 || i == word.length() - 1 || 
                    (i > 0 && word.charAt(i - 1) != '-' && 
                    !Character.isLowerCase(word.charAt(i - 1))) || 
                    (i < word.length() - 1 && !Character.isLowerCase(word.charAt(i + 1)))) {
                    return false;
                }
                hyphenCount++;
            }
            if ((ch == '.' || ch == ',' || ch == '!') && i < word.length() - 1) {
                return false;
            }
        }
        return hyphenCount <= 1;
    }
}