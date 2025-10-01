func topKFrequent(nums []int, k int) []int {
    numMap := make(map[int]int)

    for _, num := range nums {
        numMap[num]++
    }

    slice := [][]int{}

    for k, v := range numMap {
        slice = append(slice, []int{k, v})
    }

    sort.Slice(slice, func(i, j int) bool {
        return slice[i][1] > slice[j][1]
    })

    result := []int{}
    for i:=0; i < k; i++ {
        result = append(result, slice[i][0])
    }

    return result
}