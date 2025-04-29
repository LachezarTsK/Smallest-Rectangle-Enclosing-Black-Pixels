
#include <vector>
#include <algorithm>
using namespace std;

class Solution {

    static const char WHITE = '0';
    static const char BLACK = '1';

    int minBlackRow = 0;
    int maxBlackRow = 0;
    int minBlackColumn = 0;
    int maxBlackColumn = 0;

public:
    int minArea(vector<vector<char>>& image, int row, int column) {
        int rows = image.size();
        int columns = image[0].size();

        minBlackRow = row;
        maxBlackRow = row;
        minBlackColumn = column;
        maxBlackColumn = column;

        for (int r = 0; r < rows; ++r) {

            bool blackFound = false;
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

private:
    void updateOutermostValuesForFourDirections(int row, int column) {
        minBlackRow = min(minBlackRow, row);
        maxBlackRow = max(maxBlackRow, row);
        minBlackColumn = min(minBlackColumn, column);
        maxBlackColumn = max(maxBlackColumn, column);
    }
};
