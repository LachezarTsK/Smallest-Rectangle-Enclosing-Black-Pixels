
public class Solution {

    private static final char WHITE = '0';
    private static final char BLACK = '1';

    private int minBlackRow;
    private int maxBlackRow;
    private int minBlackColumn;
    private int maxBlackColumn;

    public int minArea(char[][] image, int row, int column) {
        int rows = image.length;
        int columns = image[0].length;

        minBlackRow = row;
        maxBlackRow = row;
        minBlackColumn = column;
        maxBlackColumn = column;

        for (int r = 0; r < rows; ++r) {

            boolean blackFound = false;
            for (int c = 0; c < columns; ++c) {
                if (image[r][c] == BLACK) {
                    updateOutermostValuesForFourDirections(r, c);
                    blackFound = true;
                    break;
                }
            }
            if (!blackFound) {
                continue;
            }
            for (int c = columns - 1; c >= 0; --c) {
                if (image[r][c] == BLACK) {
                    updateOutermostValuesForFourDirections(r, c);
                    break;
                }
            }
        }

        int maxHeight = maxBlackRow - minBlackRow + 1;
        int maxWidth = maxBlackColumn - minBlackColumn + 1;
        return maxHeight * maxWidth;
    }

    private void updateOutermostValuesForFourDirections(int row, int column) {
        minBlackRow = Math.min(minBlackRow, row);
        maxBlackRow = Math.max(maxBlackRow, row);
        minBlackColumn = Math.min(minBlackColumn, column);
        maxBlackColumn = Math.max(maxBlackColumn, column);
    }
}
