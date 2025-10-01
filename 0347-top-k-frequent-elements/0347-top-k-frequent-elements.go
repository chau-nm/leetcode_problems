func topKFrequent(nums []int, k int) []int {
    numMap := make(map[int]int)

    for _, num := range nums {
        numMap[num]++
    }

    buckets := make([][]int, len(nums) + 1)
    for k, v := range numMap {
        buckets[v] = append(buckets[v], k)
    }

    result := []int{}
    for i := len(buckets) - 1; i >= 0 && len(result) < k; i-- {
        if len(buckets[i]) > 0 {
            result = append(result, buckets[i]...)
        }
    }
    return result[:k]
}