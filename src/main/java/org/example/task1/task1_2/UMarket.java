package org.example.task1.task1_2;

import java.util.ArrayList;
import java.util.Collection;

public class UMarket {
    /**
     * Колекция товаров
     */
    private final Collection<Thing> things;

    public UMarket() {
        this.things = new ArrayList<>();
        initializeThings();
    }



    private void initializeThings()
    {
        things.add(new Pen());
        things.add(new Notebook());

        things.add(new Chicken());
        things.add(new Fruit());
        things.add(new OliveOil());

        things.add(new BalykCheese());
        things.add(new Crisps());
        things.add(new ChocolateBar());

        things.add(new DumplingsBerries());
        things.add(new DumplingsMeat());
        things.add(new Cheburek());
    }

    public Collection<Thing> getThings() {
        return things;
    }

    public <T extends Thing> void printThings(Class<T> clazz) {
        int index = 1;
        for (var thing : things) {
            if (clazz.isInstance(thing)) {
                if (Food.class.isAssignableFrom(thing.getClass())) {
                    System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index++, thing.getName(), ((Food) thing).getProteins() ? "Да" : "Нет",
                            ((Food) thing).getFats() ? "Да" : "Нет", ((Food) thing).getCarbohydrates() ? "Да" : "Нет");
                } else {
                    System.out.printf("[%d] %s\n", index++, thing.getName());
                }
            }
        }
    }
}
