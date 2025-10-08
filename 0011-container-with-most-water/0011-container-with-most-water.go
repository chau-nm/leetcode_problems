func maxArea(height []int) int {
    left, right := 0, len(height) - 1

    maxArea := 0
    for left < right {
        area := min(height[left], height[right]) * (right - left)
        maxArea = max(maxArea, area)

        if height[left] < height[right] {
            left++
        } else {
            right--
        }
    }

    return maxArea
}