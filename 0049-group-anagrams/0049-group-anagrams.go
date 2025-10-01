import (
    "sort"
    "strings"
)

func groupAnagrams(strs []string) [][]string {
    resultMap := make(map[string][]string)

    for _, str := range strs {
        chars := strings.Split(str, "")
        sort.Strings(chars)
        joinChar := strings.Join(chars, "")
        resultMap[joinChar] = append(resultMap[joinChar], str)
    }

    result := make([][]string, 0, len(resultMap))
    for _, val := range resultMap {
        result = append(result, val)
    }

    return result
}