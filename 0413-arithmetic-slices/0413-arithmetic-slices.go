func numberOfArithmeticSlices(nums []int) int {
    if len(nums) < 3 {
        return 0
    }

    count, current := 0, 0
    for right := 2; right < len(nums); right++ {
        if nums[right] - nums[right - 1] == nums[right - 1] - nums[right - 2] {
            current++
            count += current
        } else {
            current = 0
        }
    }

    return count
}