func trap(height []int) int {
    length := len(height)
    maxLeft, maxRight := make([]int, length), make([]int, length)

    maxLeft[0] = height[0]
    for i := 1; i < length; i++ {
        maxLeft[i] = max(maxLeft[i - 1], height[i])
    }

    maxRight[length - 1] = height[length - 1]
    for i := length - 2; i >= 0; i-- {
        maxRight[i] = max(maxRight[i + 1], height[i])
    }

    total:= 0
    for i := 0; i < length; i++ {
        total += min(maxLeft[i], maxRight[i]) - height[i]
    }

    return total
}