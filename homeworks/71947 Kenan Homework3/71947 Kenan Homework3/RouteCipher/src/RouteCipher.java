public class RouteCipher {
    private int key;

    public RouteCipher(int key) {
        setKey(key);
    }

    public void setKey(int key) {
        if (key != 0) {
            this.key = key;
        } else {
            this.key = 1;
        }
    }

    public int getKey() {
        return key;
    }

    public String encrypt(String cipherText) {
        String plainTextNoWhiteSpaces = removeExtraSymbols(cipherText);
        int columns = Math.abs(key);
        int rows = calculateRows(plainTextNoWhiteSpaces);
        char[] plainText = plainTextNoWhiteSpaces.toCharArray();
        int plainTextIndex = 0;
        char[][] grid = new char[rows][columns];

        // filling the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(plainTextIndex == plainText.length){
                    grid[i][j] = 'X';
                }
                else{
                    grid[i][j] = plainText[plainTextIndex];
                    plainTextIndex++;
                }
            }
        }
        //encrypting
        String encryptedText ="";
        if (this.key > 0){
           encryptedText = topLeftCounterClockwiseSpiralGrid(rows,columns, grid);
        }
        else {
            encryptedText = bottomRightCounterClockwiseSpiralGrid(rows,columns,grid);
        }
        return encryptedText;
    }

    private String topLeftCounterClockwiseSpiralGrid(int rows, int columns, char grid[][]) {
        String result = "";
        int i; // i - iterator
        int startingRowIndex = 0, startingColumnIndex = 0; // indexes used as start points to iterate through our grid of chars
        int countAppended = 0; // initialize the count of appended chars to result string
        int total = rows * columns; // total number of elements in the grid

        while (startingRowIndex < rows && startingColumnIndex < columns) {
            if (countAppended == total) break; // we break the cycle if we have appended all the chars from the grid to the result string

            // appending the first column from the remaining columns
            for (i = startingRowIndex; i < rows; ++i) {
                result += grid[i][startingColumnIndex];
                countAppended++;
            }
            startingColumnIndex++; // removing the first column for the next iteration

            if (countAppended == total)
                break;

            // appending the last row from the remaining rows
            for (i = startingColumnIndex; i < columns; ++i) {
                result += grid[rows - 1][i];
                countAppended++;
            }
            rows--; // removing the last row for the next iteration

            if (countAppended == total)
                break;

            // appending the last column from the remaining columns
            if (startingRowIndex < rows) {
                for (i = rows - 1; i >= startingRowIndex; --i) {
                    result += grid[i][columns - 1];
                    countAppended++;
                }
                columns--;
            }

            if (countAppended == total)
                break;

            // appending the first row from the remaining rows
            if (startingColumnIndex < columns) {
                for (i = columns - 1; i >= startingColumnIndex; --i) {
                    result += grid[startingRowIndex][i];
                    countAppended++;
                }
                startingRowIndex++;
            }
        }
        return result;
    }

    private String bottomRightCounterClockwiseSpiralGrid(int rows, int columns, char grid[][]) {
        String result = "";
        int i, startingRowIndex = rows-1, startingColumnIndex = columns-1;
        int remainingRowsBegin = 0, remainingColumnsBegin = 0;
        int countAppended = 0;
        int total = rows*columns;

        while (startingRowIndex >= remainingRowsBegin && startingColumnIndex >= remainingColumnsBegin) {
            if (countAppended == total)
                break;

            // append the last column from the remaining columns
            for (i = startingRowIndex; i >= remainingRowsBegin; --i) {
                result += grid[i][startingColumnIndex];
                countAppended++;
            }
            startingColumnIndex--;

            if (countAppended == total)
                break;

            // append the first row from the remaining rows
            for (i = startingColumnIndex; i >= remainingColumnsBegin; --i) {
                result += grid[remainingRowsBegin][i];
                countAppended++;
            }
            remainingRowsBegin++;

            if (countAppended == total)
                break;

            // append the first column from the remaining columns
            if (startingRowIndex > remainingRowsBegin) {
                for (i = remainingRowsBegin; i <= startingRowIndex; ++i) {
                    result += grid[i][remainingColumnsBegin];
                    countAppended++;
                }
                remainingColumnsBegin++;
            }

            if (countAppended == total)
                break;
            // append the last row from the remaining rows
            if (startingColumnIndex > remainingColumnsBegin) {
                for (i = remainingColumnsBegin; i <= startingColumnIndex; ++i) {
                    result += grid[startingRowIndex][i];
                    countAppended++;
                }
                startingRowIndex--;
            }
        }
        return result;
    }

    /*@Override
    public String toString(){

    }*/

    private int calculateRows(String plainText){
        double rows = (double)plainText.length() / (double)Math.abs(key);
        return (int)Math.ceil(rows);
    }

    private String removeExtraSymbols(String plainText){
        char[] plainTextChars = plainText.toCharArray();
        String result = "";
        for (char word : plainTextChars){
            if(word != ' ' && word != '.' && word != ',' && word != '!' && word != '?' && word != ';' && word != ':'){
                result += word;
            }
        }
        return result;
    }
}
