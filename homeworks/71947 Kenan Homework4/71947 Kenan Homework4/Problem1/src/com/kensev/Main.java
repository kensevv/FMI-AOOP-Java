package com.kensev;

import java.util.Scanner;

public class Main {
    public static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Input first eight bit number: ");
        byte firstNumber = reader.nextByte();
        System.out.println("Input second eight bit number: ");
        byte secondNumber = reader.nextByte();
        String firstNumberBinary = convertToBinary(firstNumber);
        String secondNumberBinary = convertToBinary(secondNumber);

        System.out.println(firstNumberBinary);
        System.out.println(secondNumberBinary);
        System.out.println(String.format("Hamming distance: %d", hammingDistance(firstNumberBinary,secondNumberBinary)));
    }

    public static byte hammingDistance(String first, String second){
        byte distance = 0;
        for (int i = 0; i < first.length() && i < second.length(); i++) {
            if (first.charAt(i) != second.charAt(i))
                distance++;
        }
        return distance;
    }

    public static String convertToBinary(byte number){
        String result = Integer.toBinaryString(number);
        while (result.length() != 8){
            result = "0" + result;
        }

        return result;
    }
}