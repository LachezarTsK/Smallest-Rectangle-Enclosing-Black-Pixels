
package main

const WHITE byte = '0'
const BLACK byte = '1'

var minBlackRow int
var maxBlackRow int
var minBlackColumn int
var maxBlackColumn int

func minArea(image [][]byte, row int, column int) int {
    rows := len(image)
    columns := len(image[0])

    minBlackRow = row
    maxBlackRow = row
    minBlackColumn = column
    maxBlackColumn = column

    for r := range rows {

        var blackFound = false
        for c := range columns {
            if image[r][c] == BLACK {
                updateOutermostValuesForFourDirections(r, c)
                blackFound = true
                break
            }
        }
        if !blackFound {
            continue
        }
        for c := +columns - 1; c >= 0; c-- {
            if image[r][c] == BLACK {
                updateOutermostValuesForFourDirections(r, c)
                break
            }
        }
    }

    maxHeight := maxBlackRow - minBlackRow + 1
    maxWidth := maxBlackColumn - minBlackColumn + 1
    return maxHeight * maxWidth
}

func updateOutermostValuesForFourDirections(row int, column int) {
    minBlackRow = min(minBlackRow, row)
    maxBlackRow = max(maxBlackRow, row)
    minBlackColumn = min(minBlackColumn, column)
    maxBlackColumn = max(maxBlackColumn, column)
}
