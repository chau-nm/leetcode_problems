func totalMoney(n int) int {
    m := n / 7
    r := n % 7
    fullSum := 7*m*(m+1)/2 + 21*m
    remainingSum := r*(2*(m+1) + r - 1) / 2
    return fullSum + remainingSum
}