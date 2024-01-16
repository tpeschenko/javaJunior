package org.example.task1.task1_2;
/**
 * Шоколадный батончик
 */
public class ChocolateBar implements Snake{
    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return true;
    }

    @Override
    public String getName() {
        return "Шоколадный батончик";
    }

}
