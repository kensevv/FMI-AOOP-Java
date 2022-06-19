package com.company;

import java.util.Random;
import java.util.Scanner;

public class SquareMatrixTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int num = scanner.nextInt();
        int[][] dataMatrix = new int[num][num];
        for(int row = 0; row < num; row++){
            for (int col = 0; col < num; col++){
                int nextNumber = scanner.nextInt();

                dataMatrix[row][col] = random.nextInt();
            }
        }

        SquareMatrix squareMatrixInst = new SquareMatrix(dataMatrix);

        int maxTwoSquareSum = squareMatrixInst.findMaxSum();

        System.out.println(maxTwoSquareSum);
    }
}

// 4

// 2 3 3 4
// 0 2 3 4
// 3 7 1 2
// 4 3 3 4
