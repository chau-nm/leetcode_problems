func findDuplicate(nums []int) int {
    set := make(map[int]bool)

    for _, num := range nums {
        if _, found := set[num]; found {
            return num
        } else {
            set[num] = true
        }
    }

    return -1
}