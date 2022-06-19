package stock;

import java.util.Scanner;

public class StockTEST {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter stock symbol: ");
        String symbol = input.nextLine();
        System.out.print("Enter stock name: ");
        String name = input.nextLine();

        Stock testStock = new Stock(symbol,name);

        System.out.print("Enter previous closing price: ");
        double previousClosingPrice = input.nextDouble();
        System.out.print("Enter current price: ");
        double currentPrice = input.nextDouble();

        testStock.setPreviousClosingPrice(previousClosingPrice);
        testStock.setCurrentPrice(currentPrice);

        System.out.printf("Symbol: %s,\nName: %s,\npreviousClosingPrice: %.2f,\ncurrentPrice: %.2f\n" +
                "changePercent: %.1f%%", testStock.getSymbol(), testStock.getName(), testStock.getPreviousClosingPrice(),
                testStock.getCurrentPrice(),testStock.changePercent());
    }
}
