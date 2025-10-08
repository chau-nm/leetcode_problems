func trap(height []int) int {
    left, right := 0, len(height) - 1
    maxLeft, maxRight := height[left], height[right]
    total := 0

    for left < right {
        if height[left] < height[right] {
            if height[left] >= maxLeft {
                maxLeft = height[left]
            } else {
                total += maxLeft - height[left]
            }
            left++
        } else {
            if height[right] >= maxRight {
                maxRight = height[right]
            } else {
                total += maxRight - height[right]
            }
            right--
        }
    }

    return total
}