func numSubarrayProductLessThanK(nums []int, k int) int {
    left, count, product := 0, 0, 1
    for right := 0; right < len(nums); right++ {
        product *= nums[right]
        for product >= k && left <= right {
            product /= nums[left]
            left++
        }
        count += right - left + 1
    }
    return count
}
