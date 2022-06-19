package test;


import com.Functions;
import com.Tabulate;
import functions.Computable;

public class TabulateTest {
    public static void main(String[] args) {
       /* Functions functions = new Functions();
        Tabulate tab = new Tabulate(functions.getSinFunction());
        tab.tabulate(2, 50, 1);*/

        Tabulate.tabulateFunction(-2, 50, 2, new Computable() {
            @Override
            public double function(double x) {
                return 1/x;
            }
        });
    }


}
