func lengthOfLongestSubstring(s string) int {
    left, maxLength := 0, 0
    index := make(map[byte]int)

    for right := 0; right < len(s); right++ {
        ch := s[right]
        if last, found := index[ch]; found && last >= left {
            left = last + 1
        }
        index[ch] = right
        if right - left + 1 > maxLength {
            maxLength = right - left + 1
        }
    }

    return maxLength
}