func nextBeautifulNumber(n int) int {
    n++
    for !isBeautifulNumber(n) {
        n++
    }
    return n
}

func isBeautifulNumber(n int) bool {
    numMap := make(map[int]int)

    for n > 0 {
        lastDigit := n % 10
        numMap[lastDigit]++
        n /= 10
    }

    for key, val := range numMap {
        if key != val {
            return false
        }
    }

    return true
}