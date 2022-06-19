package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public interface RandomCategorySupplier extends Supplier<List<Inventory>> {
    private void updateType(Category type) {
        type.getSuppliers().clear();
        int randomNumber = CanRandomize.RAND.generator.nextInt(4);
        for (int i = 0; i < randomNumber; i++) {
            type.getSuppliers().add(String.format("%s Supplier %d", type.name(), type.getReorderQty()));
        }
        type.setReorderQty(CanRandomize.RAND.generator.nextInt(10*type.getSuppliers().size()));
    }

    default List<Inventory> getRandomData(int howMany, int a, int b){
        List<Inventory> invetories = new ArrayList<>();
        for (int i = 0; i < howMany ; i++) {
            Category category = Category.A;
            updateType(category);

            int k = CanRandomize.RAND.generator.nextInt((b-a)+1)+a;
            invetories.add(new Inventory(category, k ));
        }
        return invetories;
    }
}
