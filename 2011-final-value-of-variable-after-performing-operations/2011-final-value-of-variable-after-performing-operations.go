func finalValueAfterOperations(operations []string) int {
    x := 0

    for _, operation := range operations {
        switch operation {
            case "--X", "X--":
                x--
            case "++X", "X++":
                x++
        }
    }

    return x
}