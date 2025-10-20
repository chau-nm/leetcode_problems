func minSubArrayLen(target int, nums []int) int {
    left, sum, minLength := 0, 0, len(nums) + 1

    for right := 0; right < len(nums); right++ {
        sum += nums[right]

        for sum >= target {
            minLength = min(right - left + 1, minLength)
            sum -= nums[left]
            left++
        }
    }

    if minLength == len(nums) + 1 {
        return 0
    }

    return minLength
}