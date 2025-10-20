func characterReplacement(s string, k int) int {
    count := [26]int{}

    left, maxLength, maxCount := 0, 0, 0

    for right:= 0; right < len(s); right++ {
        idx := s[right] - 'A'
        count[idx]++

        if count[idx] > maxCount {
            maxCount = count[idx]
        }

        if length := right - left + 1; length - maxCount > k {
            count[s[left] - 'A']--
            left++
        }

        if length := right - left + 1; length > maxLength {
            maxLength = length
        }
    }

    return maxLength
}