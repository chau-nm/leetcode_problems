class Solution {
    public String longestNiceSubstring(String s) {
       return dfs(s);
    }

    public String dfs(String s) {
        if (s.length() < 2) return "";

          if (s.length() < 2) return "";

        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (set.contains(Character.toLowerCase(c)) &&
                set.contains(Character.toUpperCase(c))) {
                continue;
            }

            String left = dfs(s.substring(0, i));
            String right = dfs(s.substring(i + 1));

            return left.length() >= right.length() ? left : right;
        }

        return s;
    }
}