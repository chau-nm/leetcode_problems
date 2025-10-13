func largestRectangleArea(heights []int) int {
    stack := []int{}
    maxArea := 0
    heights = append(heights, 0)

    for i, height := range heights {
        for len(stack) > 0 && height < heights[stack[len(stack) - 1]] {
            top := heights[stack[len(stack) - 1]]
            stack = stack[:len(stack) - 1]

            width := i
            if len(stack) > 0 {
                width = i - stack[len(stack)-1] - 1
            }

            area := top * width
            if area > maxArea {
                maxArea = area
            }
        }

        stack = append(stack, i)
    }
    
    return maxArea
}