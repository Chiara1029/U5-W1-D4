package it.chiarapuleio.exercise.restaurant.entities;

import it.chiarapuleio.exercise.restaurant.abstractClass.SuperMenu;

public class Toppings extends SuperMenu {

    public Toppings(String name, int kcal, double price) {
        super(name, kcal, price);
    }

    @Override
    public String toString() {
        return "Toppings{" +
                "name='" + name + '\'' +
                ", kcal=" + kcal +
                ", price=" + price +
                '}' + '\n';
    }
}

