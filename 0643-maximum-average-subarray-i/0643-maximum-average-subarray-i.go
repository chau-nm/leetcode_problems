func findMaxAverage(nums []int, k int) float64 {
    windowSum := 0

    for i := 0; i < k; i++ {
        windowSum += nums[i]
    }

    maxSum := windowSum

    for i := k; i < len(nums); i++ {
        windowSum += nums[i]
        windowSum -= nums[i - k]

        maxSum = max(windowSum, maxSum)
    }

    return float64(maxSum) / float64(k)
}