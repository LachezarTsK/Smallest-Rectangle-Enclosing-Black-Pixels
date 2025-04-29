
/**
 * @param {character[][]} image
 * @param {number} row
 * @param {number} column
 * @return {number}
 */
var minArea = function (image, row, column) {
    const WHITE = '0';
    const BLACK = '1';

    const rows = image.length;
    const columns = image[0].length;

    this.minBlackRow = row;
    this.maxBlackRow = row;
    this.minBlackColumn = column;
    this.maxBlackColumn = column;

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

    let maxHeight = this.maxBlackRow - this.minBlackRow + 1;
    let maxWidth = this.maxBlackColumn - this.minBlackColumn + 1;
    return maxHeight * maxWidth;
};

/**
 * @param {number} row
 * @param {number} column
 * @return {void}
 */
function updateOutermostValuesForFourDirections(row, column) {
    this.minBlackRow = Math.min(this.minBlackRow, row);
    this.maxBlackRow = Math.max(this.maxBlackRow, row);
    this.minBlackColumn = Math.min(this.minBlackColumn, column);
    this.maxBlackColumn = Math.max(this.maxBlackColumn, column);
}
