function getRow(rowIndex: number): number[] {
    if (rowIndex === 0) return [1];
    if (rowIndex === 1) return [1,1];
    return generateRow(getRow(rowIndex - 1));
};

function generateRow(preRow: number[]) {
    const result = [];
    for (let i = 0; i < preRow.length + 1; i++) {
        if (i === 0 || i === preRow.length) {
            result[i] = 1;
        } else {
            result[i] = preRow[i-1] + preRow[i];
        }
    } 
    return result;
}