func checkInclusion(s1 string, s2 string) bool {
    if len(s1) > len(s2) {
        return false
    }

    left := 0
    need, window := [26]int{}, [26]int{}

    for i := 0; i < len(s1); i++ {
        need[s1[i]-'a']++
    }

    for right := 0; right < len(s2); right++ {
        window[s2[right] - 'a']++

        if right - left + 1 > len(s1) {
            window[s2[left] - 'a']--
            left++
        }

        if need == window {
            return true
        }
    }

    return false
}