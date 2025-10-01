func isAnagram(s string, t string) bool {
    charMap := make(map[rune]int)

    for _, char := range s {
        charMap[char]++
    }

    for _, char := range t {
        charMap[char]--
    }

    for _, val := range charMap {
        if val != 0 {
            return false
        }
    }

    return true
}