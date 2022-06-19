package problem1;// Exercise 17.11: ProcessInvoices.java
// Processing Invoices with lambdas and streams.
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.Map.Entry.comparingByValue;

public class ProcessInvoices {
    public static void main(String[] args) {
        Invoice[] invoices = {
                new Invoice(83, "Electric sander", 7, 57.98),
                new Invoice(24, "Power saw", 18, 99.99),
                new Invoice(7, "Sledge hammer", 11, 21.50),
                new Invoice(77, "Hammer", 76, 11.99),
                new Invoice(39, "Lawn mower", 3, 79.50),
                new Invoice(68, "Screwdriver", 106, 6.99),
                new Invoice(56, "Jig saw", 21, 11.00),
                new Invoice(3, "Wrench", 34, 7.50)
        };

        //a
        System.out.println("Invoices sorted by part description:");
        Invoice[] sorted = Arrays.stream(invoices)
                .sorted((a,b) -> b.getPartDescription().compareTo(a.getPartDescription()))
                .toArray(Invoice[]::new);
        System.out.println(Arrays.toString(sorted));

        sorted = Arrays.stream(invoices)
                .sorted(Comparator.comparing(Invoice::getPartDescription))
                .toArray(Invoice[]::new);

        System.out.println(Arrays.toString(sorted));

        //b
        System.out.printf("%nnInvoices sorted by price:%n");
        sorted = Arrays.stream(invoices)
                .sorted(Comparator.comparing(Invoice::getPrice))
                .toArray(Invoice[]::new);
        System.out.println(sorted);

        //c
        System.out.printf("%nInvoices mapped to description and quantity:%n");
        Arrays.stream(invoices)
                .collect(Collectors.toMap(Invoice::getPartDescription, Invoice::getQuantity))
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .forEach(entry ->
                        System.out.printf("%-20s%-10d\n", entry.getKey(), entry.getValue()));

        //d
        System.out.printf("%nInvoices mapped to description and invoice amount:%n");
        Arrays.stream(invoices)
                .collect(Collectors.toMap(Invoice::getPartDescription,
                        invoice -> invoice.getPrice() * invoice.getQuantity()))
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .forEach(entry ->
                        System.out.printf("%-20s%-10.2f\n", entry.getKey(), entry.getValue()));

        //e)
        System.out.printf("%nInvoices mapped to description and invoice amount for invoices in the range 200-500:%n");
        Arrays.stream(invoices)
                .collect(Collectors.toMap(Invoice::getPartDescription,
                        invoice -> invoice.getPrice() * invoice.getQuantity()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= 200 && entry.getValue() <= 500)
                .sorted(comparingByValue())
                .forEach(entry ->
                        System.out.printf("%-20s%-10.2f\n", entry.getKey(), entry.getValue()));

        //f)
        Set<Invoice> below = Arrays.stream(invoices)
                .filter(invoice -> invoice.getPrice() * invoice.getQuantity() <= 300)
                .collect(Collectors.toSet());
        System.out.printf("%nSet with invoice values below or equal to 300: " + below);

        Set<Invoice> above = Arrays.stream(invoices)
                .filter(invoice -> invoice.getPrice() * invoice.getQuantity() > 300)
                .collect(Collectors.toSet());
        System.out.printf("%nSet with invoice values above 300: %n" + above);

        //g)
        System.out.printf("%nMap with hashcode and sorted by price%n");
        Map<Integer, Invoice> map = Arrays.stream(invoices)
                .collect(Collectors.toMap(
                        invoice -> invoice.hashCode(), Function.identity()));

        map.entrySet().stream()
                .sorted((a,b) ->
                        (int) (b.getValue().getPrice() - a.getValue().getPrice()) * 100)
                .forEach(entry -> System.out.printf("%-20d%-100s\n", entry.getKey(), entry.getValue()));

        //vtori variant za sortirane
        System.out.printf("%nMap with hashcode and sorted by price%n");
        map.entrySet().stream()
                .sorted(comparingByValue(Comparator.comparing((Invoice::getPrice))))
                .forEach(entry
                        -> System.out.printf("%-20d%-100s\n", entry.getKey(), entry.getValue()));

    }
}