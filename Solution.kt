
import kotlin.math.min
import kotlin.math.max

class Solution {

    private companion object {
        const val WHITE = '0'
        const val BLACK = '1'
    }

    private var minBlackRow: Int = 0
    private var maxBlackRow: Int = 0
    private var minBlackColumn: Int = 0
    private var maxBlackColumn: Int = 0

    fun minArea(image: Array<CharArray>, row: Int, column: Int): Int {
        val rows = image.size
        val columns = image[0].size

        minBlackRow = row
        maxBlackRow = row
        minBlackColumn = column
        maxBlackColumn = column

        for (r in 0..<rows) {

            var blackFound = false
            for (c in 0..<columns) {
                if (image[r][c] == BLACK) {
                    updateOutermostValuesForFourDirections(r, c)
                    blackFound = true
                    break
                }
            }
            if (!blackFound) {
                continue
            }
            for (c in columns - 1 downTo 0) {
                if (image[r][c] == BLACK) {
                    updateOutermostValuesForFourDirections(r, c)
                    break
                }
            }
        }

        val maxHeight = maxBlackRow - minBlackRow + 1
        val maxWidth = maxBlackColumn - minBlackColumn + 1
        return maxHeight * maxWidth
    }

    private fun updateOutermostValuesForFourDirections(row: Int, column: Int): Unit {
        minBlackRow = min(minBlackRow, row)
        maxBlackRow = max(maxBlackRow, row)
        minBlackColumn = min(minBlackColumn, column)
        maxBlackColumn = max(maxBlackColumn, column)
    }
}
