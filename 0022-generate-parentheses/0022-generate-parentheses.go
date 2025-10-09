func generateParenthesis(n int) []string {
    type State struct {
        current string
        open int
        close int
    }

    stack := []State{State{current: "", open: 0, close: 0}}
    result := []string{}

    for len(stack) > 0 {
        top := stack[len(stack) - 1]
        stack = stack[:len(stack) - 1]

        if len(top.current) == n * 2 {
            result = append(result, top.current)
            continue
        }

        if top.open < n {
            stack = append(stack, State{
                current: top.current + "(",
                open: top.open + 1,
                close: top.close,
            })
        }

        if top.close < top.open {
            stack = append(stack, State{
                current: top.current + ")",
                open: top.open,
                close: top.close + 1,
            })
        }
    }

    return result
}