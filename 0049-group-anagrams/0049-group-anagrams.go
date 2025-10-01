func groupAnagrams(strs []string) [][]string {
    resultMap := make(map[string][]string)

    for _, str := range strs {
        count := make([]int, 26)
        for _, ch := range str {
            count[ch - 'a']++
        }

        key := strings.Trim(strings.Replace(fmt.Sprint(count), " ", "#", -1), "[]")
        resultMap[key] = append(resultMap[key], str)
    }

    result := make([][]string, 0, len(resultMap))
    for _, val := range resultMap {
        result = append(result, val)
    }

    return result
}