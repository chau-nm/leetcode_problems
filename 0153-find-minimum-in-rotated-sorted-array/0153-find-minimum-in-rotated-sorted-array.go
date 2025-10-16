func findMin(nums []int) int {
    left, right := 0, len(nums) - 1

    for left < right {
        middle := (left + right) / 2

        if nums[middle] > nums[right] {
            left = middle + 1
        } else {
            right = middle
        }
    }

    return nums[left]
}