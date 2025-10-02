func isValidSudoku(board [][]byte) bool {
    row := make([][]bool, 9)
    col := make([][]bool, 9)
    box := make([][]bool, 9)

    for i := 0; i < 9; i++ {
        row[i] = make([]bool, 9)
        col[i] = make([]bool, 9)
        box[i] = make([]bool, 9)
    }

    for i := 0; i < len(board); i++ {
        for j := 0; j < len(board[i]); j++ {
            if board[i][j] != '.' {
                num := board[i][j] - '1'
                boxIndex := (i/3)*3 + (j/3)
                if row[i][num] || col[j][num] || box[boxIndex][num] {
                    return false
                }
                row[i][num] = true
                col[j][num] = true
                box[boxIndex][num] = true
            }
        }
    }
    return true
}