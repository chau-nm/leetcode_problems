func productExceptSelf(nums []int) []int {
    answer := make([]int, len(nums))

    prefix := 1
    for i, num := range nums {
        answer[i] = prefix
        prefix *= num
    }

    suffix := 1
    for i := len(nums) - 1; i >= 0; i-- {
        answer[i] *= suffix
        suffix *= nums[i]
    }

    return answer
}