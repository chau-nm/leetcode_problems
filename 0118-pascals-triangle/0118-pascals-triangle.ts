function generate(numRows: number): number[][] {
    const result = [];
    for (let i = 0; i < numRows; i++) {
        result[i] = generateRowRecur(i);
    }
    return result;
};

function generateRow(preRow: number[]) {
    const result = [];
    for (let i = 0; i < preRow.length + 1; i++) {
        if (i === 0 || i === preRow.length) {
            result[i] = 1;
        } else {
            result[i] = preRow[i - 1] + preRow[i];
        }
    }
    return result;
}

function generateRowRecur(row: number) {
    if (row === 0) return [1];
    if (row === 1) return [1, 1];
    return generateRow(generateRowRecur(row-1));
}