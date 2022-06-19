package p11;

import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class CheckString {
    public static void main(String[] args) throws StringTooLongException {
        final int MAX_CHARACTERS=20;
        Scanner input = new Scanner(System.in);

        StringTooLongException stringTooLongException =
                new StringTooLongException("String has more than 20 characters");

        String userInput="";
        while (!userInput.equals("DONE")){
            System.out.println("Enter string or end with DONE:");
            userInput=input.nextLine();
            if (!userInput.equals("DONE")){
                if (userInput.length()>MAX_CHARACTERS){
                    throw stringTooLongException;
                }

            }
        }
        System.out.println("Program completed successfully");

    }
}
