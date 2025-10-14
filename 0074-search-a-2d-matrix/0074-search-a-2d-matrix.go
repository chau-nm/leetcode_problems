func searchMatrix(matrix [][]int, target int) bool {
    arr := []int{}

    for _, row := range matrix {
        arr = append(arr, row...)
    }

    left := 0
    right := len(arr) - 1

    for left <= right {
        middle := (left + right) / 2

        if arr[middle] == target {
            return true
        } else if arr[middle] > target {
            right = middle - 1
        } else {
            left = middle + 1
        }
    }

    return false
}