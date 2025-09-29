func containsDuplicate(nums []int) bool {
    numMap := make(map[int]int)

    for i, num := range nums {
        if _, found := numMap[num]; found {
            return true;
        }
        numMap[num] = i
    }
    return false
}