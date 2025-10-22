func maxFrequency(nums []int, k int, numOperations int) int {
    diff := map[int]int{}
    freq := map[int]int{}
    set := map[int]struct{}{}

    for _, num := range nums {
        lo := max(0, num - k)
        hi := min(1e9+1, num + k + 1)
        set[lo] = struct{}{}
        set[hi] = struct{}{}
        set[num] = struct{}{}
        diff[lo]++
        diff[hi]--
        freq[num]++
    }

    importantNums := make([]int, 0, len(set))
    for num, _ := range set {
        importantNums = append(importantNums, num)
    }
    sort.Ints(importantNums)

    overlap := 0
    out := 0
    for _, num := range importantNums {
        overlap += diff[num]
        out = max(out, freq[num] + min(overlap - freq[num], numOperations))
    }
    return out
}