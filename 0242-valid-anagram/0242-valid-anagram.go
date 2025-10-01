func isAnagram(s string, t string) bool {
    charMap := make(map[rune]int)

    for _, char := range s {
        if val, found := charMap[char]; found {
            charMap[char] = val + 1
        } else {
            charMap[char] = 1
        }
    }

    for _, char := range t {
        if val, found := charMap[char]; found {
            charMap[char] = val - 1
        } else {
            return false
        }
    }

    for _, val := range charMap {
        if (val != 0) {
            return false
        }
    }

    return true
}