func isValid(s string) bool {
    pairs := map[rune]rune{
		'(': ')',
		'{': '}',
		'[': ']',
	}

    stack := []rune{}

    for _, char := range s {
        if _, ok := pairs[char]; ok {
            stack = append(stack, char)
        } else if len(stack) == 0 || pairs[stack[len(stack)-1]] != char {
            return false
        } else {
            stack = stack[:len(stack) - 1]
        }
    }

    return len(stack) == 0
}