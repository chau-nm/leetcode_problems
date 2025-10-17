func maxProfit(prices []int) int {
    if len(prices) < 2 {
        return 0
    }

    left, right := 0, 1

    maxProfit := 0

    for right < len(prices) {
        if prices[left] < prices[right] {
            profit := prices[right] - prices[left]
            maxProfit = max(maxProfit, profit)
        } else {
            left = right
        }
        right++
    }

    return maxProfit
}