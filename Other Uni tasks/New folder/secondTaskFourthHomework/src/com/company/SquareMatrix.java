package com.company;

public class SquareMatrix {
    int[][] dataMatrix;

    SquareMatrix(){
        int rows = 0;
        int cols = 0;
        dataMatrix = new int[rows][cols];
    }

    SquareMatrix(int[][] dataMatrix){
        this.dataMatrix = dataMatrix;
    }

    int[][] getDataMatrix(){
        return dataMatrix;
    }

    void setDataMatrix(int[][] dataMatrixOne){
        this.dataMatrix = dataMatrixOne;
    }

    public String toString(){
        int rows = dataMatrix.length;
        int cols = dataMatrix[0].length;

        String result = "";
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                result += dataMatrix[row][col];
            }
        }

        return result;
    }

    public int findMaxSum(){
        int maxSum = 0;
        int currentSum = 0;

        int topSum = 0;
        int bottomSum = 0;

        int rows = dataMatrix.length;
        int cols = dataMatrix[0].length;

        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++) {
                if(row + 1 >= rows || col + 1 >= cols) break;

                topSum += dataMatrix[row][col] + dataMatrix[row][col + 1];
                bottomSum += dataMatrix[row + 1][col] + dataMatrix[row + 1][col + 1];

                currentSum += topSum + bottomSum;

                topSum = 0;
                bottomSum = 0;

                if (currentSum > maxSum) maxSum = currentSum;
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public void printAll(){
        int maxSum = 0;
        int currentSum = 0;

        int topSum = 0;
        int bottomSum = 0;

        int rows = dataMatrix.length;
        int cols = dataMatrix[0].length;

        int maxRowIndexTop = 0;
        int maxColIndexTop = 0;
        int maxRowIndexBottom = 0;
        int maxColIndexBottom = 0;
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++) {
                if(row + 1 >= rows || col + 1 >= cols) break;

                topSum += dataMatrix[row][col] + dataMatrix[row][col + 1];
                bottomSum += dataMatrix[row + 1][col] + dataMatrix[row + 1][col + 1];

                currentSum += topSum + bottomSum;


                if (currentSum > maxSum){
                    maxSum = currentSum;
                    maxRowIndexTop = row;
                    maxColIndexTop = col + 1;
                    maxRowIndexBottom = row + 1;
                    maxColIndexBottom = col + 1;
                }
                currentSum = 0;

                topSum = 0;
                bottomSum =     0;
            }
        }

        System.out.println("(" + maxRowIndexTop + "," + maxColIndexTop + ")");
        System.out.println("(" + maxRowIndexBottom + "," + maxColIndexBottom + ")");
        System.out.println("The max sum is is: " + maxSum);
    }
}
