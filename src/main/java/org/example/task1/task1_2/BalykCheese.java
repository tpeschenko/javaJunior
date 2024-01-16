package org.example.task1.task1_2;

/**
 * Сыр Балыковый (балык)
 */
public class BalykCheese implements Snake{
    @Override
    public boolean getProteins() {
        return true;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Сыр балык";
    }
}
