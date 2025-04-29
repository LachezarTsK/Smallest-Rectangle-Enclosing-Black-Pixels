
public class Solution
{
    private static readonly char WHITE = '0';
    private static readonly char BLACK = '1';

    private int minBlackRow;
    private int maxBlackRow;
    private int minBlackColumn;
    private int maxBlackColumn;

    public int MinArea(char[][] image, int row, int column)
    {
        int rows = image.Length;
        int columns = image[0].Length;

        minBlackRow = row;
        maxBlackRow = row;
        minBlackColumn = column;
        maxBlackColumn = column;

        for (int r = 0; r < rows; ++r)
        {

            bool blackFound = false;
            for (int c = 0; c < columns; ++c)
            {
                if (image[r][c] == BLACK)
                {
                    UpdateOutermostValuesForFourDirections(r, c);
                    blackFound = true;
                    break;
                }
            }
            if (!blackFound)
            {
                continue;
            }
            for (int c = columns - 1; c >= 0; --c)
            {
                if (image[r][c] == BLACK)
                {
                    UpdateOutermostValuesForFourDirections(r, c);
                    break;
                }
            }
        }

        int maxHeight = maxBlackRow - minBlackRow + 1;
        int maxWidth = maxBlackColumn - minBlackColumn + 1;
        return maxHeight * maxWidth;
    }

    private void UpdateOutermostValuesForFourDirections(int row, int column)
    {
        minBlackRow = Math.Min(minBlackRow, row);
        maxBlackRow = Math.Max(maxBlackRow, row);
        minBlackColumn = Math.Min(minBlackColumn, column);
        maxBlackColumn = Math.Max(maxBlackColumn, column);
    }
}
