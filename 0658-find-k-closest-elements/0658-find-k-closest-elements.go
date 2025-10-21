func findClosestElements(arr []int, k int, x int) []int {
    left, right := 0, len(arr)-1
    for left < right {
        mid := (left + right) / 2
        if arr[mid] < x {
            left = mid + 1
        } else {
            right = mid
        }
    }
    
    l, r := left-1, left
    for i := 0; i < k; i++ {
        if l >= 0 && (r >= len(arr) || abs(arr[l]-x) <= abs(arr[r]-x)) {
            l--
        } else {
            r++
        }
    }
    return arr[l+1:r]
}

func abs(a int) int {
    if a < 0 {
        return -a
    }
    return a
}