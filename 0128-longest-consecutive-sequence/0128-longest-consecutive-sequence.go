func longestConsecutive(nums []int) int {
    numMap := make(map[int]bool)

    for _, num := range nums {
        numMap[num] = true
    }

    longest := 0
    for key, _ := range numMap {
        if !numMap[key-1] {
            length := 1
            current := key
            for numMap[current+1] {
                current++
                length++
            }
            if length > longest {
                longest = length
            }
        }
    }

    return longest
}