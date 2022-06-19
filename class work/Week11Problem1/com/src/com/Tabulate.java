package com;

import functions.Computable;

import java.util.Scanner;

public class Tabulate {
    private Computable callback;

    public Tabulate(Computable callback){
        setCallback(callback);
    }
    public Computable getCallback(){
        return callback;
    }
    public void setCallback(Computable callback){
        if(callback != null){
            this.callback = callback;
        }
        else
        {
            this.callback = new Functions().getSinFunction();
        }
    }
    public void tabulate(double a, double b, int steps){
        tabulateFunction(a, b, steps, callback);
    }
    public static void tabulateFunction(double a, double b, int steps, Computable computable){
        if( a>=b){
            System.out.println("Please provide well defined interval");
            return;
        }
        if (steps <=0){
            System.out.println("Please provide well defined step!");
            return;
        }

        System.out.printf("%10s%10s\n", "X", "F(X)");
        double size = (b-a) /steps;
        double x, y;
        Scanner input = new Scanner(System.in);
        for (int i = 1; i<=size; i++){
            x = a + i * steps;
            y = computable.function(x);
            System.out.printf("%10.2f%10.2f\n", x, y);
            if(i%20==0){
                System.out.println("Please press enter to continue...");
                input.nextLine();
            }
        }
    }
}
