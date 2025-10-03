
import (
    "strings"
    "unicode"
)

func isPalindrome(s string) bool {
    var builder strings.Builder
    for _, r := range strings.ToLower(s) {
        if unicode.IsLetter(r) || unicode.IsDigit(r) {
            builder.WriteRune(r)
        }
    }

    runes := []rune(builder.String())
    n := len(runes)

    for i := 0; i < n/2; i++ {
        if runes[i] != runes[n-1-i] {
            return false
        }
    }
    return true
}