func dailyTemperatures(temperatures []int) []int {
    stack := []int{}
    result := make([]int, len(temperatures))

    for i, temp := range temperatures {
       for len(stack) > 0 && temperatures[stack[len(stack)-1]] < temp {
			index := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			result[index] = i - index
		}
		stack = append(stack, i)
    }

    return result
}