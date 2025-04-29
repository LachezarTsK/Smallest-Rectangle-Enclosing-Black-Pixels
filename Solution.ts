
let minBlackRow: number;
let maxBlackRow: number;
let minBlackColumn: number;
let maxBlackColumn: number;

function minArea(image: string[][], row: number, column: number): number {
    const WHITE = '0';
    const BLACK = '1';

    const rows = image.length;
    const columns = image[0].length;

    minBlackRow = row;
    maxBlackRow = row;
    minBlackColumn = column;
    maxBlackColumn = column;

    for (let r = 0; r < rows; ++r) {

        let blackFound = false;
        for (let c = 0; c < columns; ++c) {
            if (image[r][c] === BLACK) {
                updateOutermostValuesForFourDirections(r, c);
                blackFound = true;
                break;
            }
        }
        if (!blackFound) {
            continue;
        }
        for (let c = columns - 1; c >= 0; --c) {
            if (image[r][c] === BLACK) {
                updateOutermostValuesForFourDirections(r, c);
                break;
            }
        }
    }

    let maxHeight = maxBlackRow - minBlackRow + 1;
    let maxWidth = maxBlackColumn - minBlackColumn + 1;
    return maxHeight * maxWidth;
};

function updateOutermostValuesForFourDirections(row: number, column: number): void {
    minBlackRow = Math.min(minBlackRow, row);
    maxBlackRow = Math.max(maxBlackRow, row);
    minBlackColumn = Math.min(minBlackColumn, column);
    maxBlackColumn = Math.max(maxBlackColumn, column);
}
