package it.chiarapuleio.exercise.restaurant.entities;

import it.chiarapuleio.exercise.restaurant.abstractClass.SuperMenu;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("pizzas")
public class Pizza  extends SuperMenu {
    private String description;
    private List<Toppings> toppings;

    public Pizza(String name, int kcal, double price) {
        super(name, kcal, price);
        this.description = "Tomato and cheese";
    }

    public Pizza(String name, int kcal, double price, List<Toppings> toppings) {
        super(name, kcal, price);
        this.toppings = toppings;
        this.description = "Tomato, Cheese";
    }

    @Override
    public String toString() {
        StringBuilder toppingsStr = new StringBuilder();
        if(toppings != null && !toppings.isEmpty()){
            toppingsStr.append(", ");
            for(Toppings topping : toppings){
                if(topping != null){
                    toppingsStr.append(topping.getName()).append(", ");
                }
            }
            toppingsStr.setLength(toppingsStr.length() -2);
        }
        return "Pizza{" +
                "name='" + name + '\'' +
                ", description=" + description + toppingsStr +
                ", kcal=" + kcal +
                ", price=" + price +
                '}' + '\n' ;
    }
}
