package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryManagement {
    private RandomCategorySupplier supplier;
    private List<Inventory> invetories;
    private StringBuilder sb;

    public InventoryManagement() {
        this.sb = new StringBuilder(50);

        this.supplier = () -> {
            return new ArrayList<>();
        };

        this.invetories = supplier.getRandomData(10, 120, 500);
    }

    public String showInventory(){
        sb.setLength(0); //resetting SB
        invetories.stream().forEach(inventory -> {
            sb.append(inventory);
            sb.append("\n");
        });

        return sb.toString();
    }

    public double averagePrice()
    {
        return invetories.stream().mapToDouble(Inventory::getPrice).average().getAsDouble();
    }

    public List<Inventory> sortInventoryTypeAndID(){
        return invetories.stream()
                .sorted((invetory1, inventory2) -> invetory1.getCategory().name().compareTo(inventory2.getCategory().name()))
                .sorted( (i1, i2) -> i1.getInvDescription().compareTo(i2.getInvDescription()))
                .collect(Collectors.toList());
    }

    public String findLargestPricePerCategory(){
        //return invetories.stream().map(Inventory::getCategory).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return "";
    }
}
