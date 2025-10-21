func maxFrequency(nums []int, k int, numOperations int) int {
    mx := nums[0]
    for _, x := range nums {
        if x > mx {
            mx = x
        }
    }
    n := mx + k + 2
    f := make([]int, n)
    for _, x := range nums {
        f[x]++
    }
    pre := make([]int, n)
    pre[0] = f[0]
    for i := 1; i < n; i++ {
        pre[i] = pre[i-1] + f[i]
    }
    ans := 0
    for t := 0; t < n; t++ {
        if f[t] == 0 && numOperations == 0 {
            continue
        }
        l := t - k
        if l < 0 {
            l = 0
        }
        r := t + k
        if r > n-1 {
            r = n - 1
        }
        tot := pre[r]
        if l > 0 {
            tot -= pre[l-1]
        }
        adj := tot - f[t]
        val := f[t] + min(numOperations, adj)
        if val > ans {
            ans = val
        }
    }
    return ans
}