package it.chiarapuleio.exercise.restaurant.entities;

import it.chiarapuleio.exercise.restaurant.abstractClass.SuperMenu;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Entity
@DiscriminatorValue("toppings")
public class Toppings extends SuperMenu {

    @ManyToMany
    @JoinTable(name = "topping-pizza", joinColumns = @JoinColumn(name = "topping_id"), inverseJoinColumns = @JoinColumn(name = "pizza_id"))
    private List<Pizza> pizzas;

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

