package it.chiarapuleio.exercise.restaurant.entities;

import it.chiarapuleio.exercise.restaurant.abstractClass.SuperMenu;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("drinks")
public class Drink extends SuperMenu {
    public Drink(String name, int kcal, double price) {
        super(name, kcal, price);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", kcal=" + kcal +
                ", price=" + price +
                '}' + '\n';
    }
}
