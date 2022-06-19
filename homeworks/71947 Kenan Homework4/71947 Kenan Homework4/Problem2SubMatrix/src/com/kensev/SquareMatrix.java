package com.kensev;

import java.util.ArrayList;

public class SquareMatrix {
    private int[][] dataArray;

    public SquareMatrix() {
        this(new int[0][0]);
    }

    public SquareMatrix(int[][] dataArray){
        this.setDataArray(dataArray);
    }

    public SquareMatrix(SquareMatrix other){
        setDataArray(other.getDataArray()); // getDataArray returns deep copy.
    }

    public int[][] getDataArray() {
        // returning deep copy of 2 dimensional array
        int[][] dataArrayCopy = new int[dataArray.length][];
        for (int i = 0; i < dataArray.length; i++) {
            dataArrayCopy[i] = new int[dataArray.length];
            for (int j = 0; j < dataArray[i].length; j++) {
                dataArrayCopy[i][j] = dataArray[i][j];
            }
        }
        return dataArrayCopy;
    }

    public void setDataArray(int[][] dataArray) {
        if (dataArray != null) {
            this.dataArray = dataArray;
        }
        else {
            this.dataArray = new int[0][0] ;
        }
    }

    public int findMaxSum(){
        int currentRow = 0;
        int currentColumn = 0;
        int maxSum = Integer.MIN_VALUE;

        while (currentRow <= this.dataArray.length - 2){
            currentColumn = 0;
            while (currentColumn <= this.dataArray.length - 2) {
                int currentSum = returnCurrentSumOfSubMatrix(currentRow, currentColumn);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
                currentColumn++;
            }
            currentRow++;
        }
        return maxSum;
    }

    private int returnCurrentSumOfSubMatrix(int row, int column){
        return this.dataArray[row][column] + this.dataArray[row][column + 1]
                + this.dataArray[row + 1][column] + this.dataArray[row + 1][column + 1];
    }

    private ArrayList<String> findAllMaxSubmatrices(int maxSum){
        int currentRow = 0;
        int currentColumn = 0;

        ArrayList<String> maxSubmatrices = new ArrayList<>();

        while (currentRow <= this.dataArray.length - 2){
            currentColumn = 0;
            while (currentColumn <= this.dataArray.length - 2) {
                int currentSum = returnCurrentSumOfSubMatrix(currentRow, currentColumn);

                if (currentSum == maxSum) {
                    maxSubmatrices.add("[" + currentRow + ", " + currentColumn + "]");
                }
                currentColumn++;
            }
            currentRow++;
        }
        return maxSubmatrices;
    }

    public void printAll(){
        int maxSum = findMaxSum();
        ArrayList<String> maxSubmatrices = findAllMaxSubmatrices(maxSum);

        System.out.println("Maximum sum: " + maxSum);
        System.out.println("Submatrices with Maximum sum:");
        for (String submatrix : maxSubmatrices){
            System.out.print(submatrix + " ");
        }
    }

    public String toString(){
        String result = "";

        for (int[] row : this.dataArray){
            for (int element : row){
                result += String.format("%d ",element);
            }
            result += "\n";
        }
        return result;
    }
}
