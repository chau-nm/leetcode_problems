func findAnagrams(s string, p string) []int {
    pFreq := make([]int, 26)
    sFreq := make([]int, 26)

    for i := 0; i < len(p); i++ {
        pFreq[p[i]-'a']++
    }

    result := []int{}
    for i := 0; i < len(s); i++ {
        sFreq[s[i] - 'a']++

        if i >= len(p) {
            sFreq[s[i-len(p)]-'a']--
        }

        if isEqual(pFreq, sFreq) {
            result = append(result, i-len(p)+1)
        }
    }

    return result
}

func isEqual(a, b []int) bool {
    for i := 0; i < 26; i++ {
        if a[i] != b[i] {
            return false
        }
    }
    return true
}