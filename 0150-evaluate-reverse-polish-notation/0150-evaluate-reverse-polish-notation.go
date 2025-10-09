import (
    "slices"
)

func evalRPN(tokens []string) int {
    stack := []int{}
    operations := []string{"+", "-", "*", "/"}

    for _, elm := range tokens {
        if index := slices.Index(operations, elm); index < 0 {
            num, _ := strconv.Atoi(elm)
            stack = append(stack, int(num))
        } else {
            num2 := stack[len(stack) - 1]
            num1 := stack[len(stack) - 2]
            stack = stack[:len(stack) - 2]
            var result int
            switch elm {
                case "+":
                    result = num1 + num2
                case "-":
                    result = num1 - num2
                case "*":
                    result = num1 * num2
                case "/":
                    result = num1 / num2
            }
            stack = append(stack, result)
        }
    }

    return stack[0]
}