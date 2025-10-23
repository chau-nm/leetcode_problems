func hasSameDigits(s string) bool {
    for len(s) > 2 {
        newDigits := ""        
        for i := 1; i < len(s); i++ {
            newDigits += string((int(s[i]) + int(s[i - 1])) % 10)
        }
        s = newDigits
    }
    if len(s) < 2 {
        return false
    }
    return s[1] == s[0]
}