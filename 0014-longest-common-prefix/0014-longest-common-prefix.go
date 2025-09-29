func longestCommonPrefix(strs []string) string {
    res := ""
    for i, _ := range strs[0] {
        for _, word := range strs {
            if i == len(word) || word[i] != strs[0][i] {
                return res
            }
        }
        res += string(strs[0][i])
    }
    return res
}